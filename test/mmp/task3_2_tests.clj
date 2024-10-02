(ns mmp.task3-2-tests
  (:require [clojure.test :as test])
  (:require [mmp.task3-2 :refer :all]))

(test/deftest task3-2-tests
  (test/testing "Testing task3.2"
    (test/is (= (doall (take N (filter pred (range))))
                (doall (pfilter pred 0 (/ N 10) N 0))))
    (println "Filter")
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (println "Pfilter")
    (time (doall (pfilter pred 0 (/ N 10) N 0)))
    (time (doall (pfilter pred 0 (/ N 10) N 0)))
    (time (doall (pfilter pred 0 (/ N 10) N 0)))
    ))

(test/run-tests 'mmp.task3-2-tests)