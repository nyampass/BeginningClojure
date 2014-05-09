(ns shorter.models.links-db
  (require [monger.core :as mg]
           [monger.collection :as mc]
           [monger.operators :as mo]))

(mg/connect!)
(mg/set-db! (mg/get-db "shorter"))

(defn new-id []
  (let [new-document
        (mc/find-and-modify "links"
                            {:_id "current-id"}
                            {mo/$inc {"value" 1}}
                            :upsert true
                            :return-new true)]
    (:value new-document)))

(defn add-link! [url]
  (let [new-id (new-id)
        document (mc/insert-and-return "links" {:url url})
        {id :_id} document]
    (str id))

;; (add-link! "")

(defn fetch-link [id]
  (if-let [document (mc/find-one-as-map "links" {:_id id})]
    (:url document)))
