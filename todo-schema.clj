(require '[datomic.client.api :as d])
(def cfg {:server-type :peer-server
                 :access-key "myaccesskey"
                 :secret "mysecret"
                 :validate-hostnames false
                 :endpoint "datomic-peer-server:8998"})
(def client (d/client cfg))
(def conn (d/connect client {:db-name "app"}))
(def db (d/db conn))

(def schema
  [{:db/ident :todos/title
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}
   {:db/ident :todos/archived
    :db/valueType :db.type/boolean
    :db/cardinality :db.cardinality/one}])

(d/transact conn {:tx-data schema})

; insert
(d/transact conn {:tx-data [{:todos/title "foo", :todos/archived false}]})

; select title from todos
(d/q '[:find ?e :where [_ :todos/title ?e]] db)

; select * from todos
(d/q '[:find (pull ?e [*]) :where [?e :todos/title]] db)
