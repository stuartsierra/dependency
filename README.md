# Dependency

A data structure for representing dependency graphs in Clojure.

This library provides a basic implementation of a directed acyclic
graph (DAG) data structure, represented as a pair of maps. It is
immutable and persistent.

Nodes in the graph may be any type which supports Clojure's equality
semantics such as keywords, symbols, or strings.

I originally developed this library to support namespace dependency
tracking in [tools.namespace], where it is still included under the
name `clojure.tools.namespace.dependency`.

I am releasing this library independently so that other projects can
use it without adding a dependency on all of tools.namespace.

[tools.namespace]: https://github.com/clojure/tools.namespace


## Releases and Dependency Information

This library is released on [Clojars]. Latest release is 0.2.0

[Leiningen] dependency information:

    [com.stuartsierra/dependency "0.2.0"]

[Clojars]: http://clojars.org/
[Leiningen]: http://leiningen.org/


## Version Compatibility

Version 0.2.0 requires Clojure 1.7.0 or higher for
Conditional Read (`.cljc`) support.

Version 0.2.0 also supports ClojureScript versions with
Conditional Read.

Version 0.1.1 of this library remains compatible with
Clojure versions 1.3.0, 1.4.0, and 1.5.1.


## Usage

    (require '[com.stuartsierra.dependency :as dep])

Create a new dependency graph:

    (def g1 (-> (dep/graph)
                (dep/depend :b :a)   ; "B depends on A"
                (dep/depend :c :b)   ; "C depends on B"
                (dep/depend :c :a)   ; "C depends on A"
                (dep/depend :d :c))) ; "D depends on C"

This creates a structure like the following:

         :a
        / |
      :b  |
        \ |
         :c
          |
         :d

Ask questions of the graph:

    (dep/transitive-dependencies g1 :d)
    ;;=> #{:a :c :b}

    (dep/depends? g1 :d :b)
    ;;=> true

Get a topological sort:

    (dep/topo-sort g1)
    ;;=> (:a :b :c :d)

Refer to the docstrings for more API documentation. Refer to the tests
for more examples.


## Development and Contributing

This library is a repackaging of `clojure.tools.namespace.dependency`.
All changes must go through [tools.namespace] and the Clojure
[contributing] process.


## Change Log

* Release 0.2.0 on 18-Sept-2015
  * Convert to `.cljc` for ClojureScript support
  * Apply enhancements and fixes up to [tools.namespace]
    version 0.3.0-alpha1
* Release 0.1.1 on 03-Jun-2013
  * A node may not depend on itself; fixes [#1]
* Release 0.1.0 on 07-Apr-2013

[#1]: https://github.com/stuartsierra/dependency/pull/1
[tools.namespace]: https://github.com/clojure/tools.namespace
[contributing]: http://dev.clojure.org/display/community/Contributing


## Copyright and License

Copyright (c) Stuart Sierra, 2012-2015. All rights reserved. The use
and distribution terms for this software are covered by the Eclipse
Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this
distribution. By using this software in any fashion, you are agreeing
to be bound by the terms of this license. You must not remove this
notice, or any other, from this software.
