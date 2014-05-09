(ns shorter.models.links
  (:use [clojure.string :only [join]]))

;; ここでatomを使おうと考えた。refに変更

(defn char-range [[first-char end-char]]
         (map char (range (int first-char) (int end-char))))

;; (char-range [\a \z])

(def key-characters (apply concat (map char-range [[\0 \9] [\a \z] [\A \Z]])))

(defn index->key [index]
  (loop [index index acc []]
    (if (zero? index)
      (-> acc reverse join)
      (recur (long (/ index (count key-characters)))
             (conj acc (nth key-characters
                            (mod index (count key-characters))))))))

;; def -> defonce

(defonce links (ref {}))
(defonce index (ref 0))

(defn add-link! [url]
  (dosync
   (let [new-index (alter index inc)
         new-key (index->key new-index)]
     (alter links assoc
            new-key url))))

;; (add-link! "http:/www.yahoo.com/")

(defn fetch-link [index]
  (get @links index))

;; (fetch-link "1")
