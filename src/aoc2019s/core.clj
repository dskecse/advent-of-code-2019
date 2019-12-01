(ns aoc2019s.core
  (:require [clojure.java.io :as io]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; fuel required to launch a module is based on its mass
;; mass / 3
;; round down
;; subtract 2
(defn fuel-req [mass]
  ;; (println mass)
  ;; (println (type mass))
  ;; (println (read-string mass))
  (- (int (/ mass 3)) 2))

;; problem
;; find out total fuel requirement
;; individually calculate the fuel needed for the mass of each module (puzzle input)
;; then add them together
;; (defn module-masses
;;   (with-open [rdr (io/reader "input1.txt")]
;;     (doall (map fuel-req (line-seq rdr)))))
(defn module-masses []
  (with-open [rdr (io/reader "input1.txt")]
    ;; (println (type rdr))
    ;; (println (type (line-seq rdr)))
    ;; (println (line-seq rdr))
    ;; (Integer/parseInt s) (read-string s)
    (doall (map fuel-req (map read-string (line-seq rdr))))))

(defn total-fuel-req []
  (reduce + 0 (module-masses)))

;; #error {
;;  :cause Call to clojure.core/defn did not conform to spec.
;;
;; https://stackoverflow.com/questions/58291671/call-to-clojure-core-defn-did-not-conform-to-spec
(defn masses []
  0)
