(defproject chaoscillator "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"] [overtone "0.10.1"] [org.clojure/data.csv "0.1.3"]]
  :main ^:skip-aot chaoscillator.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
