(defproject shorter "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [com.novemberain/monger "1.7.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler shorter.handler/app})
