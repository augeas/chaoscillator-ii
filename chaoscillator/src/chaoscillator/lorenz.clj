(ns chaoscillator.lorenz)

(defn lorenz [sigma rho beta]
  (vector
   (fn [_ [x y _]] (* sigma (- y x)))
   (fn [_ [x y z]] (- (* x (- rho z)) y))
   (fn [_ [x y z]] (- (* x y) (* beta z)))
  )
)
