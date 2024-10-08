(ns mmp.task3-2-tests
  (:require [clojure.test :as test])
  (:require [mmp.task3-2 :refer :all]))

(test/deftest task3-2-tests
  (test/testing "Testing task3.2"
    (test/is (= (doall (take N (filter pred (range))))
                (doall (take N (pfilter pred (range) (/ N 10))))
                ))
    (println "Filter")
    (time (doall (take N (filter pred (range)))))
    (time (doall (take N (filter pred (range)))))
    (println "Pfilter")
    (time (take N (pfilter pred (range) (/ N 10))))
    (time (doall (take N (pfilter pred (range) (/ N 10)))))
    (time (doall (take N (pfilter pred (range) (/ N 10)))))
    ))

(test/run-tests 'mmp.task3-2-tests)