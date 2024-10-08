(ns mmp.task2-1-tests
  (:require [clojure.test :as test])
   (:require [mmp.task2-1 :refer :all])
  )

(test/deftest task2-1-tests
  (test/testing "Testing task2.1"
     (test/is (= (S my-f 2 3 0.1) (S-mem my-f 2 3 0.1)))
     (test/is (= (S my-f 2 -3 0.1) "a must be less then b"))
     (println "S")
     (time (S my-f a b h))
     (time (S my-f a b h))
     (time (S my-f a (+ b 5) h))
     (time (S my-f a (+ b 10) h))
     (println "S-mem")
     (time (S-mem my-f a b h))
     (time (S-mem my-f a b h))
     (time (S-mem my-f a (+ b 3) h))
     (time (S-mem my-f a (+ b 5) h))
     (time (S-mem my-f a (+ b 10) h))
    ))

(test/run-tests 'mmp.task2-1-tests)