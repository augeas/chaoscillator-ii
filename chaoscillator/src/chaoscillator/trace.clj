(ns chaoscillator.trace)

(defn norm [[mi mx]] (
  let [ rng (- mx mi)]
  (fn [x] (/ (- x mi) rng))
))

(defn vector-apply [fv vv]
  (apply vector (map apply fv (apply vector (map vector vv))))
)

(defn vector-norm [rv] (
  let [fv (map norm rv)]
  (partial vector-apply fv)
))

(defn norm-seq [vn sq] (
  for [x sq]
  (vn (x 1))
))

(require '[clojure.data.csv :as csv] '[clojure.java.io :as io])

(defn dump-trace [sq n] (
  (with-open [trace-out (io/writer "trace-out.csv")]
    (csv/write-csv trace-out (take n sq))
  )
))
