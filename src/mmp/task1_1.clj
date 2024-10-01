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
  [word alf]
  (if (> (count alf) 0)
    (remove empty? (cons
                    (try-add word (first alf))
                    (while-alf word (rest alf))))))

(defn for-words
  "For word in words"
  [current-list n]
  (if (> (count current-list) 0)
    (if (< (count (first current-list)) n)
      (for-words (concat
                  (while-alf (first current-list) my-list)
                  (for-words (rest current-list) n)) n)
      current-list)
    current-list))

(for-words words N)