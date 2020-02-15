(require '[datomic.client.api :as d])
(def cfg {:server-type :peer-server
                 :access-key "myaccesskey"
                 :secret "mysecret"
                 :validate-hostnames false
                 :endpoint "datomic-peer-server:8998"})
(def client (d/client cfg))
(def conn (d/connect client {:db-name "app"}))

(d/transact conn {:tx-data [{:db/doc "hello world"}]})

(def db (d/db conn))
(d/q '[:find (max 3 ?tx)
       :where [?tx :db/txInstant]]
     db)
(d/pull db [:db/ident :red])

(def schema-1
  [{:db/ident :inv/sku
    :db/valueType :db.type/string
    :db/unique :db.unique/identity
    :db/cardinality :db.cardinality/one}
   {:db/ident :inv/color
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   {:db/ident :inv/size
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   {:db/ident :inv/type
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}])
(d/transact conn {:tx-data schema-1})

(def sizes [:small :medium :large :xlarge])
(def types [:shirt :pants :dress :hat])
(def colors [:red :green :blue :yellow])

(def sample-data
  (->> (for [color colors size sizes type types]
         {:inv/color color
          :inv/size size
          :inv/type type})
       (map-indexed
        (fn [idx map]
          (assoc map :inv/sku (str "SKU-" idx))))
        vec))
(d/transact conn {:tx-data sample-data})

(d/transact
    conn
    {:tx-data [{:db/ident :red}
               {:db/ident :green}
               {:db/ident :blue}
               {:db/ident :yellow}]})

(d/q '[:find ?e :where [:db/ident ?e]] db)
