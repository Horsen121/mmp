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

(defn pfilter
  [pred start h n ccount]
  (let [input-coll (take n (iterate inc start))
        parts (my-split (/ n 10) input-coll)
        coll (->>
               (map #(my-future pred %) parts)
               (doall)
               (map deref)
               (doall)
               (reduce concat)
               )
        ]
    (concat coll (if (< (+ ccount (count coll)) n)
      (pfilter pred (+ start n) h n (+ ccount (count coll)))
      (list)
      ))
    )
  )

(def N 100)
(def pred (fn [x] (Thread/sleep 1) (even? x)))