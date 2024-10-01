(ns mmp.task1-tests
  (:require [clojure.test :as test])
  (:require [task1.task1-3])
  (:import [task1.task1-3 my-map my-filter]))

(test/deftest my-map-test
  (test/testing "Testing my-map"
    (test/is (= (my-map inc (list 1 2 3 4)) (map inc (list 1 2 3 4))))
    (test/is (= (my-map dec (list 1 2 3 4)) (map dec (list 1 2 3 4))))
    (test/is (= (my-map - (list 1 2 3 4)) (map - (list 1 2 3 4))))))

(test/deftest my-filter-test
  (test/testing "Testing my-filter"
    (test/is (= (my-filter even? (list 1 2 3 4 6 8)) (filter even? (list 1 2 3 4 6 8))))
    (test/is (= (my-filter (fn [x] (= (mod x 3) 0)) (list 1 2 3 4 6 8)) (filter (fn [x] (= (mod x 3) 0)) (list 1 2 3 4 6 8))))))

(test/run-tests 'task1.task1-tests)