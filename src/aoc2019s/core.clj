(ns aoc2019s.core
  (:require [clojure.java.io :as io]))

;; fuel required for a given mass
;; mass / 3
;; round down
;; subtract 2
(defn fuel [mass]
  ;; (println mass)
  ;; (println (type mass))
  ;; (println (read-string mass))
  (- (int (/ mass 3)) 2))

;; (defn module-masses
;;   (with-open [rdr (io/reader "input1.txt")]
;;     (doall (map fuel-req (line-seq rdr)))))
(def module-masses
  (with-open [rdr (io/reader "input1.txt")]
    ;; (println (type rdr))
    ;; (println (type (line-seq rdr)))
    ;; (println (line-seq rdr))
    ;; (Integer/parseInt s) (read-string s)
    (doall (map read-string (line-seq rdr)))))

;; problem
;; find out total fuel requirement
;; individually calculate the fuel needed for the mass of each module (puzzle input)
;; then add them together
;; (def module-fuel
;;   (map fuel module-masses))

(defn total-module-fuel [module-mass]
  (reduce + 0 (take-while pos? (iterate fuel (fuel module-mass)))))

(def total
  (reduce + 0 (map total-module-fuel module-masses)))
