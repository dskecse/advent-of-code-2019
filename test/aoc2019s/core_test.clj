(ns aoc2019s.core-test
  (:require [clojure.test :refer :all]
            [aoc2019s.core :refer :all]))

(deftest fuel-required-for-mass
  (is (= 2 (fuel 12)))
  (is (= 2 (fuel 14)))
  (is (= 654 (fuel 1969)))
  (is (= 33583 (fuel 100756))))

(deftest total-fuel-required-for-module-mass
  (is (= 2 (total-module-fuel 12)))
  (is (= 966 (total-module-fuel 1969)))
  (is (= 50346 (total-module-fuel 100756))))
