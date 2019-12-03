(ns aoc2019s.core
  (:require [clojure.string :as str])
  (:require [clojure.core.match :refer [match]]))

;; Problem description: https://adventofcode.com/2019/day/2
;; Part 1

;; Example usage:
;;
;;   (intcode (slurp "input2.txt"))
;;
(defn intcode [input]
  (mapv read-string (str/split input #",")))

(defn opcode [intcode]
  (first intcode))

(defn process-opcode [intcode]
  (match (opcode intcode)
    1     +
    2     *
    99    nil
    :else (throw (Exception. "Something went wrong"))))

(defn set-value [value addr mem]
  (swap! (atom mem) assoc addr value))

;; (defn run [intcode]
;;   (let [xs (take 4 intcode)]
;;     ((process-opcode xs) (nth intcode (nth xs 1)) (nth intcode (nth xs 2)))
;;   )
; (run [5 6 7 8] [1 2 3 4 5 6 7 8 99])
(defn proc [xs intcode]
  (let [pos1 (nth xs 1)
        pos2 (nth xs 2)
        op (process-opcode xs)]
    (set-value (op (nth intcode pos1) (nth intcode pos2)) (nth xs 3) intcode))
    ; (swap! (atom intcode) assoc (nth xs 3)
    ;        (op (nth intcode pos1) (nth intcode pos2))))
  )

; (partition-all 4 [1 2 3 4 5 6 7 8 9])
; ((1 2 3 4) (5 6 7 8) (9))

; (take-while (= (opcode intcode) 99) (iterate (

(defn run
  ([xs] (let [xz (proc (take 4 xs) xs)] (run (drop 4 xz) xz)))
  ([xs acc]
   (if (= (opcode xs) 99)
     acc
     (recur (drop 4 xs) (proc xs acc)))))

; [1 1 1 4 99 5 6 0 99]
; (run (99 5 6 0 99) (proc (1 1 1 4) [1 1 1 4 99 5 6 0 99]))
; (run (99 5 6 0 99) (1 1 1 4 2 5 6 0 99))
; true
;
; (run (2 5 6 0 99) (1 1 1 4 2 5 6 0 99))
; (run (99) (proc (2 5 6 0 99) (1 1 1 4 2 5 6 0 99)))
; (run (99) (30 1 1 4 2 5 6 0 99))
; true

; (println (first (run (intcode (slurp "input2.txt")))))
(->> "input2.txt"
     (slurp)
     (intcode)
     (set-value 12 1)
     (set-value 2 2)
     (run)
     (first)
     (println))
