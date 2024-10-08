(ns mmp.task2-1
  (:gen-class))

(defn trap
  [f a h]
   (* (/ (+ (f a) (f (+ a h))) 2) h)
  )

(defn S
  "Squire from a to b"
  [f a b h]
  (if (< a b)
      (reduce +
               0
               (map #(trap f % h) (range a b h))
               )
    "a must be less then b"))

(def a 0)
(def b 5)
(def h 0.1)
(def my-f (fn [t] (Thread/sleep 1) (* t t)))

(def S-mem (memoize S))
(def my-f-mem (memoize my-f))