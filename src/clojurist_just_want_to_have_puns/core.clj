(ns clojurists-just-want-to-have-puns.core
  (:gen-class)
  (:require [clj-http.client :as client]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (client/get "http://rhymebrain.com/talk?function=getRhymes&word=heart")))
