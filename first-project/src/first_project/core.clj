(ns first-project.core
  (:gen-class))
(gen-class)
(defn parse-int [str]
  (Integer. str))

(defn -main [& args]
  ()
  (println "Sum: " (reduce + (map parse-int args))))
