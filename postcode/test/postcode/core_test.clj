(ns postcode.core-test
  (:require [clojure.test :refer :all]
            [postcode.core :refer :all]))

(deftest valid-postcode?-test
  (testing "Good pattern"
    (is (valid-postcode? "141-6022"))
    (is (valid-postcode? "343-0825"))
    (is (valid-postcode? "899-1302")))
  (testing "Bad pattern"
    (is (not (valid-postcode? "")))
    (is (not (valid-postcode? nil)))
    (is (not (valid-postcode? "1441-24111")))
    (is (not (valid-postcode? "-343-0825")))
    (is (not (valid-postcode? "3-12")))
    (is (not (valid-postcode? "1234\n343-0825\n")))
    (is (not (valid-postcode? "1441-24111")))))

;; (run-tests)
