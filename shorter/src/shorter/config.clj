(ns shorter.config)

(defn assoc-crud-mapping [type results]
  (assoc-meta results
              ::crud-mapping type))

(defmulti config (fn [key] key))

(defmethod config :production [key]
  {:port 8080
   :db-name "shorter-production"})

(defmethod config :default [key]
  {:port 8080
   :db-name "shorter-development"})

(config :production)
(config nil)
(config :development)

