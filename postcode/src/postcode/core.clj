(ns postcode.core)

(defn valid-postcode? [postcode]
  (if postcode
    (boolean (re-find #"^\d{3}-\d{4}$" postcode))))
