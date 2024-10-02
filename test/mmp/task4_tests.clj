(ns mmp.task4-tests
  (:require [clojure.test :as test])
  (:require [mmp.task4 :refer :all]))

(test/deftest task4-tests
  (test/testing "Testing task2.2"
    (test/is (= () ()))
    ))

(test/run-tests 'mmp.task4-tests)