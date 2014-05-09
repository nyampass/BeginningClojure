(ns mongo.core)

(require '[monger.core :as mg]
         '[monger.collection :as mc]
         '[monger.operators :as mo])

(mg/connect!)
(mg/set-db! (mg/get-db "test"))

(mc/insert "documents" {:name "Taro" :age 30})


(for [obj (mc/find-maps "documents")]
  obj)

(mc/find-maps "documents" {:age 30})

(mc/find-one-as-map "documents" {:name "Taro"})

(mc/update "documents" {:name "Taro"} {:sex "male"})

(mc/update "documents" {:name "Taro"} {mo/$set {:sex "male"}})

(mc/remove "documents" {:name "Taro"})
