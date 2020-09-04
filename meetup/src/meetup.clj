(ns meetup
  (:require [java-time :as j])
)

(defn get-all-days [year mon day]
  (apply vector (map #(j/as % :day-of-month) (take-while #(= (j/month %) (j/month mon)) (j/iterate j/plus (j/adjust (j/local-date year mon 1) :first-in-month day)  (j/days 7)))))
)

; (defn get-all-days [mon year day]
;   (->> (j/local-date year mon 1)
;        (j/adjust % :first-in-month day)
;        (j/iterate j/plus % (j/days 7))
;        (take-while #(= (j/month %) (j/month mon)) %)
;        (map #(j/as % :day-of-month))     
;   )
; )

(defn get-date [month year day which]
  (let [all-days (get-all-days year month day)]
    (case which
      :first first
      :second second 
      :third #(nth % 2)
      :fourth #(nth % 3)
      :last last
      :teenth (first (filter #(<= 13 % 19) %)))
  )
)

; find all the dates for given 'day' in a month; as an array
; pick the nth item in the array
; for teenth, check the array by value
(defn meetup [month year day which]
  [year month (get-date month year day which)]
)