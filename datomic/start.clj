(require '[datomic.api :as d])
(def db-uri (format "datomic:dev://localhost:4334/%s" (System/getenv "DATOMIC_DB") ))
(d/create-database db-uri)

(prn (format "Database '%s' is created" (System/getenv "DATOMIC_DB")))
