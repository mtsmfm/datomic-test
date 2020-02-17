(ns backend.core
  (:require [io.pedestal.http :as http]
            [com.walmartlabs.lacinia.pedestal :as lacinia]
            [com.walmartlabs.lacinia.schema :as schema]))

(def schema (schema/compile
             {:objects
              {:todo
               {:fields {:id {:type ID}
                         :title {:type String}
                         :archived {:type Boolean}}}}

              :queries {:todos
                        {:type 'String
                         :resolve (constantly "world")}}}))

(def service (lacinia/service-map schema))

(defonce runnable-service (http/create-server service))

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (println "\nCreating your server...")
  (http/start runnable-service))
