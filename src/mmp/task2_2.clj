(ns mmp.task2-2
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

(defn- my-iterator
  [[step_sum index] f h]
  [(+ step_sum (trap f (* h index) h))
  (inc index)]
  )
(defn S-flow
  [f a b h]
  (let [coll (map first (iterate #(my-iterator % f h) [a 0]))]
    (nth coll (/ b h))
    )
  )

(def a 0)
(def b 5)
(def h 0.1)
(def my-f (fn [t] (Thread/sleep 1) (* t t)))