(ns aoc2019s.core-test
  (:require [clojure.test :refer :all]
            [aoc2019s.core :refer :all]))

(deftest fuel-required
  (is (= 2 (fuel-req 12)))
  (is (= 2 (fuel-req 14)))
  (is (= 654 (fuel-req 1969)))
  (is (= 33583 (fuel-req 100756))))
