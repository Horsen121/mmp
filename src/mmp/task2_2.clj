(ns mmp.task2-2
  (:require [clojure.math :as math])
  (:gen-class))

(defn trap
  [f a h]
  (Thread/sleep 1)
  (* (/ (+ (f a) (f (+ a h))) 2) h)
  )

(defn S
  "Squire from a to b"
  [f a b h]
  (if (< a b)
    (reduce +
            0
            (map #(trap f % h) (range a (- b h) h))
            )
    "a must be less then b"))

(defn my-split
  [n coll]
  (if (not-empty coll)
    (let [first (take n coll)
          second (drop n coll)]
      (if (not-empty first)
        (cons first (my-split n second))
        (list)
        )
      )
    )
  )
(defn my-future
  [f h coll]
    (future (doall (map #(trap f % h) coll)))
  )
(defn S-flow
  "Squire with flow"
  [f a h n]
  (let [coll (take n (iterate (partial + h) a))
        parts (my-split (/ n 10) coll)
        ]
  (->>
    (map #(my-future f h %) parts)
    (doall)
    (map deref)
    (doall)
    (reduce concat)
    (reduce +)
    )
  )
  )

(def a 2)
(def b 3)
(def h 0.01)
(def my-f (fn [t] (* t t))) ; (double (/ 1 (math/log t)))


(time (S my-f a b h))
(time (S my-f a b h))
(time (S-flow my-f a h (/ (- b a) h)))
(time (S-flow my-f a h (/ (- b a) h)))