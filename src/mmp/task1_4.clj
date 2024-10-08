(ns mmp.task1-4
  (:require [mmp.task1-3  :refer :all]))


(def my-list  (list "a" "b" "c"))
(def words my-list)
(def N 2)

(defn plus-char
  "Create new word while alf not nil with 'map' and 'filter'"
  [w]
  (my-filter not-empty
             (reduce concat
                     (list)
                     (my-map (fn [x] (concat
                                      (my-map (fn [y] (if (not= (last x) (last y))
                                                        (+ x y)
                                                        ())) my-list))) w))))

(defn words-n
  "For word in words withot 'recur'"
  []
  (reduce (fn [s _] (if (< (count (first s)) N)
                      (plus-char s)
                      s))
          words
          words))

(words-n)