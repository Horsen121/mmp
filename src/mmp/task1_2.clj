(def my-list  (list "a" "b" "c"))
(def words my-list)
(def N 2)

(defn try-add
  "Check el of list is not the same previous and try create a new word"
  [word cur]
  (if (not= (last word) (first cur))
    (+ word cur)
    ()))

(defn while-alf
  "Create new word while alf not nil"
  ([word alf] (while-alf word alf (list)))
  ([word alf res]
   (if (> (count alf) 0)
     (recur word (take (- (count alf) 1) alf)
            (remove empty? (cons
                            (try-add word (last alf))
                            res)))
     res)))

(defn for-words
  "For word in words with 'recur'"
  [current-list n]
  (if (> (count current-list) 0)
    (if (< (count (first current-list)) n)
      (recur (concat
              (while-alf (first current-list) my-list)
              (for-words (rest current-list) n)) n)
      current-list)
    current-list))


(for-words words N)