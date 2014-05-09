(ns mongo.users
  (require [monger.core :refer [connect! connect set-db! get-db]]
           [monger.collection :as collection]
           [monger.operators :refer :all]
           [monger.result :as result]
           [crypto.password.bcrypt :as password]))

(password/encrypt "hoge")

(def encryped-password (password/encrypt "hoge"))

(password/check "hoge" encryped-password)
(password/check "fuga" encryped-password)

(connect!)
(set-db! (monger.core/get-db "test"))

(defn add-user! [email password]
  (collection/insert "users"
                     {:_id email
                      :password (password/encrypt password)
                      :created-at (java.util.Date.)}))

;; (add-user! "t.noborio@gmail.com" "pass")

(defn authentication [email password]
  (if-let [user (collection/find-one-as-map "users"
                                            {:_id email})]
    (if (password/check password
                        (:password user))
      (dissoc user :password))))

;; (authentication "t.noborio@gmail.com" "pass")

(defn change-password! [email old-password new-password]
  (if-let [user (authentication email old-password)]
    (result/updated-existing?
     (collection/update "users"
                        {:_id (:_id user)}
                        {$set {:password (password/encrypt new-password)
                               :updated-at (java.util.Date.)}}))))

;; (change-password! "t.noborio@gmail.com" "pass2" "pass2")

(defn users []
  (let [users (collection/find-maps "users")]
    (map #(dissoc % :password) users)))

;; (users)

