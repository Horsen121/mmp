(ns mmp.task3-1
  (:gen-class))

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

(defn pfilter
  [pred coll n]
  (let [parts (my-split n coll)]
 (->>
   (map #(future (filter pred %)) parts)
   (doall)
   (map deref)
   (doall)
   (reduce concat)
   )
  )
  )

(def N 100)
(def pred (fn [x] (Thread/sleep 1) (even? x)))

(time (doall (filter pred (range N))))
(time (doall (filter pred (range N))))
(time (doall (filter pred (range N))))
(time (pfilter pred (range N) (/ N 10)))
(time (pfilter pred (range N) (/ N 10)))
(time (pfilter pred (range N) (/ N 10)))