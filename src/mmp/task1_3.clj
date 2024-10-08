(ns mmp.task1-3
  (:gen-class))

(defn my-map
  [f coll]
  (if (> (count coll) 0)
    (reduce
     conj
     (my-map f (rest coll))
     (list (f (first coll))))
    (list)))

(my-map + (list 1 2 3 4))


(defn my-filter
  [pred coll]
  (if (> (count coll) 0)
    (reduce
     conj
     (my-filter pred (rest coll))
     (if (pred (first coll))
       (list (first coll))
       (list)))
    (list)))

(my-filter even? (list 1 2 3 4 6 8))