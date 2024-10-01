(ns mmp.task3-2-tests
  (:require [clojure.test :as test])
  (:require [mmp.task3-2 :refer :all]))

(test/deftest task3-2-tests
  (test/testing "Testing task2.2"
    (test/is (= (doall (filter pred (range N)))
                (pfilter pred (/ N 10) N)))
    (println "Filter")
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (println "Pfilter")
    (time (pfilter pred (/ N 10) N))
    (time (pfilter pred (/ N 10) N))
    (time (pfilter pred (/ N 10) N))
    ))

(test/run-tests 'mmp.task3-2-tests)