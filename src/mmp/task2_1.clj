(ns mmp.task2-1
  (:require [clojure.math :as math])
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
               (map #(trap f % h) (range a b h))      ;(+ a h)
               )
    "a must be less then b"))

(def S-mem (memoize S))
(def a 0)
(def b 3000)
(def h 0.01)
(def my-f (fn [t] (* t t)))     ; double (/ 1 (math/log t))


(time (S my-f a b h))
(time (S my-f a b h))
(time (S my-f a b h))
(time (S my-f a (+ b 5) h))
(time (S my-f a (+ b 6) h))
(println)
(time (S-mem my-f a b h))
(time (S-mem my-f a b h))
(time (S-mem my-f a (+ b 5) h))
(time (S-mem my-f a (+ b 6) h))