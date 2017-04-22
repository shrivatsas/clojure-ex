(ns anagram
  (:use [clojure.string :only [lower-case]]))

(defn same-word? [word potential-anagram]
  (and
      (not= word potential-anagram)
      (not= (lower-case word) (lower-case potential-anagram))))

(defn same-letters? [word potential-anagram]
  (= (sort (lower-case word)) (sort (lower-case potential-anagram))))

(defn anagram? [word potential-anagram] 
  (and
    (same-word? word potential-anagram)
    (same-letters? word potential-anagram)))

(defn anagrams-for [word, potential-anagrams]
  (filter (partial anagram? word) potential-anagrams))
