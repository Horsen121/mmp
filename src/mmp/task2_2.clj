(ns mmp.task2-2
  (:require [clojure.math :as math])
  (:gen-class))

(defn trap
  [f a h]
  ;(
  ;(Thread/sleep 100)
  (* (/ (+ (f a) (f (+ a h))) 2) h)
  ;)
  )

(defn S
  "Squire from a to b"
  [f a b h]
  (if (< a b)
    (* (reduce +
               0
               (map #(trap f % h) (range a b h))
               )
       h)
    "a must be less then b"))

(defn S-flow
  "Squire with flow"
  [f a h n]
  (->>
    (iterate (partial + h) a)
    (take n)
    (map #(future (fn [list] (trap f list h)) %))
    ;(doall)
    ;(map deref)
    ;(doall)
    ;(reduce +)
    ;(* h)
    )
  )

(def a 0)
(def b 30)
(def h 0.01)
(def my-f (fn [t] (* t t))) ; (double (/ 1 (math/log t)))


(time (S my-f a b h))
(time (S my-f a b h))
(time (S-flow my-f a h (/ (- b a) h)))
(time (S-flow my-f a h (/ (- b a) h)))