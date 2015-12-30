(ns clojurists-just-want-to-have-puns.rhymebrain
  (:gen-class)
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn get-rhymes
  "Retrieves rhymes from RhymeBrain for a given word"
  [word]
  (json/read-str (get (client/get 
                   (format "http://rhymebrain.com/talk?function=getRhymes&word=%s" word)
                   {:as :json}) 
                 :body)))

(defn filter-rhymes
  "Filters rhymes to those with a score above or equal to the specified minimum or 300 if none provided"
  [rhymes & {:keys [minimum] :or {minimum 300}}]
  (filter (fn [rhyme]
            (>= (get rhyme "score" 0) minimum))
          rhymes))

(defn get-rhyme-words
  "Returns a vector of just the rhyme words"
  [rhymes]
  (map #(get % "word") rhymes))
