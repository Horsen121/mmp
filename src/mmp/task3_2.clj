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

(defn my-future
  [pred coll]
  (future (doall (filter pred  coll)))
  )
(defn future-filter
  [pred coll n]
  (let [parts (my-split n coll)]
    (->>
      (map #(my-future pred %) parts)
      (doall)
      (map deref)
      (doall)
      (reduce concat)
      )
    )
  )

(defn pfilter
  [pred coll n]
  (lazy-seq (concat
    (future-filter pred (take n coll) (/ n 2))
      (pfilter pred (drop n coll) n)
    )
  ))

(def N 100)
(def pred (fn [x] (Thread/sleep 1) (even? x)))