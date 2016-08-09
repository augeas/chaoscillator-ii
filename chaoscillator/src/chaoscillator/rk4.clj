(ns chaoscillator.rk4)

(defn pdiff [n] (fn [v d] (assoc v n (+ d (v n)))))

(defn rk4 [i f h] (
  let [h2 (/ h 2.0) h6 (/ h 6.0) delta (pdiff i)] (
    fn [t v] (
      let [
        t2 (+ t h2)
        k1 (f t v)
        k2 (f t2 (delta v (* h2 k1)))
        k3 (f t2 (delta v (* h2 k2)))
        k4 (f (+ t h) (delta v (* h k3)))
      ]      
      (+ (v i) (* h6 (+ k1 (* 2 k2) (* 2 k3) k4)))
    )
  )
))

(defn rk4-vec [fv h] ((apply juxt (map-indexed #(partial rk4 %1 %2) fv)) h))

(defn runge-kutta [fv h t v] (
  let [
    rk (apply juxt (rk4-vec fv h))
    f (fn [[tt vv]] (vector (+ tt h) (rk tt vv)))
  ] (iterate f [t v])
))
