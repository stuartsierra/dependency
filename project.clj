(defproject com.stuartsierra/dependency "0.2.0-SNAPSHOT"
  :description "A data structure for representing dependency graphs"
  :url "https://github.com/stuartsierra/dependency"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :clj-1.4.0 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :clj-1.3.0 {:dependencies [[org.clojure/clojure "1.3.0"]]}})
