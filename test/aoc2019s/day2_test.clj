(ns aoc2019s.day2-test
  (:require [clojure.test :refer :all]
            [aoc2019s.day2 :refer :all]))

(deftest reads-intcode-from-input-correctly
  (is (= [1 0 0 3 99] (intcode "1,0,0,3,99")))
  (is (= [2 4 4 5 99 0] (intcode "2,4,4,5,99,0"))))

(deftest detects-opcode
  (is (= 1 (opcode [1 0 0 3])))
  (is (= 2 (opcode [2 4 4 5]))))

(deftest processes-opcode
  (is (= + (process-opcode [1 0 0 3])))
  (is (= * (process-opcode [2 4 4 5])))
  (is (= nil (process-opcode [99 0])))
  (is (thrown-with-msg? Exception #"Something went wrong"
                        (process-opcode [3 4 5 6]))))

(deftest opcode-1-adds-integers
  (is (= [2 0 0 0 99] (run [1 0 0 0 99])))
  (is (= [2 3 0 6 99] (run [2 3 0 3 99])))
  (is (= [2 4 4 5 99 9801] (run [2 4 4 5 99 0])))
  (is (= [30 1 1 4 2 5 6 0 99] (run [1 1 1 4 99 5 6 0 99])))
  (is (thrown? Exception (run [3 0 0 0 99])))
  )
