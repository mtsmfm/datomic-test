(defproject backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
    [org.clojure/clojure "1.10.0"]
    [com.datomic/client-pro "0.9.43"]
    [com.walmartlabs/lacinia "0.36.0"]
    [com.walmartlabs/lacinia-pedestal "0.13.0"]
    [org.slf4j/slf4j-simple "1.7.30"]]
  :plugins [[lein-cljfmt "0.6.6"]]
  :main ^:skip-aot backend.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
