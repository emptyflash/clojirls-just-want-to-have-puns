(ns clojirls-just-want-to-have-puns.core
  (:gen-class)
  (:require [clojirls-just-want-to-have-puns.rhymebrain :as rhymebrain]
            [clojure.string :as str]))

(defn get-lines-from-file
  "Gets lines from the filename given"
  [filename]
  (str/split-lines (slurp filename)))

(defn replace-rhyme-in-line-with-word
  "Replaces the word in a line with the rhyme"
  [line rhyme word]
  (str/replace
    line
    (re-pattern (format "\\b%s\\b" rhyme))
    word))

(defn contains-whole-word?
  "Returns whether or not a line contains the whole word"
  [line word]
  (not (nil? (re-matches
               (re-pattern (format ".*\\b%s\\b.*" word))
               line))))

(defn get-good-rhyme-words
  "Gets all rhyme words over 300 for a given word"
  [word]
  (rhymebrain/get-rhyme-words
    (rhymebrain/filter-rhymes
      (rhymebrain/get-rhymes word))))

(defn get-lines-with-rhymes-replaced
  "Gets all the lines that have rhymes in them with the rhyme replaced with the word"
  [lines rhymes word]
  (for [line lines rhyme rhymes
        :when (contains-whole-word? line rhyme)]
    [(replace-rhyme-in-line-with-word line rhyme word) line]))

(defn -main
  "Gets a list of puns (original phrase and pun phrase) by replacing words rhyming with a specified word in lines of a specified file"
  [& args]
  (def specified-word (first args))
  (def specified-file (second args))
  (println (str/join "\n"
    (map #(str (first %) " (pun of " (last %) ")")
      (get-lines-with-rhymes-replaced
        (get-lines-from-file specified-file)
        (get-good-rhyme-words specified-word)
        specified-word)))))
