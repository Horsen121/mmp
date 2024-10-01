(ns mmp.task3-2
  (:gen-class))

(defn my-split
  [h coll]
  (lazy-seq
    (if (not-empty coll)
    (let [first (take h coll)
          second (drop h coll)]
      (if (not-empty first)
        (cons first (my-split h second))
        (list)
        )
      )
    )
    )
  )

(defn pfilter
  [pred h n]
    (->>
      (iterate inc 0)
      (take n)
      (my-split h)
      (map #(future (filter pred %)))
      (doall)
      (map deref)
      (doall)
      (reduce concat)
      )
    )

(def N 100)
(def pred (fn [x] (Thread/sleep 1) (even? x)))

(time (doall (filter pred (range N))))
(time (doall (filter pred (range N))))
(time (doall (filter pred (range N))))
(time (pfilter pred (/ N 10) N))
(time (pfilter pred (/ N 10) N))
(time (pfilter pred (/ N 10) N))