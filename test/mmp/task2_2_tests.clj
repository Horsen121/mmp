(ns mmp.task2-2-tests
  (:require [clojure.test :as test])
  (:require [mmp.task2-2 :refer :all]))

(test/deftest task2-2-tests
  (test/testing "Testing task2.2"
    (test/is (= (S my-f a b h) (S-flow my-f a b h)))
    (time (S my-f a b h))
    (time (S my-f a b h))
    (time (S my-f a (+ b 5) h))
    (time (S my-f a (+ b 10) h))
    (println "S-flow")
    (time (S-flow my-f a b h))
    (time (S-flow my-f a b h))
    (time (S-flow my-f a (+ b 5) h))
    (time (S-flow my-f a (+ b 10) h))
    ))

(test/run-tests 'mmp.task2-2-tests)