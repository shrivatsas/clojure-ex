(ns armstrong-numbers)

(defn exp [n x]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [snum (str num)]
    (= num (reduce + 
      (map #(exp (count snum) %) (map #(Character/getNumericValue %) snum))))))
