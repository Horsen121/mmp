(ns mmp.task3-1-tests
  (:require [clojure.test :as test])
  (:require [mmp.task3-1 :refer :all]))

(test/deftest task3-1-tests
  (test/testing "Testing task3.1"
    (test/is (= (doall (filter pred (range N)))
                (doall (pfilter pred (range N) (/ N 10)))))
    (println "Filter")
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (time (doall (filter pred (range N))))
    (println "Pfilter")
    (time (doall (pfilter pred (range N) (/ N 10))))
    (time (doall (pfilter pred (range N) (/ N 10))))
    (time (doall (pfilter pred (range N) (/ N 10))))
    ))

(test/run-tests 'mmp.task3-1-tests)