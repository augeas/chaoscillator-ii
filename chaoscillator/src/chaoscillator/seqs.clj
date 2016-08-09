
(use 'chaoscillator.lorenz)
(use 'chaoscillator.rk4)
(use 'chaoscillator.trace)

(def standard-lorenz (lorenz 10.0 28.0 (/ 8.0 3.0)))

(def lorenz-1 (runge-kutta standard-lorenz 0.01 0.0 [0.1 0.1 0.1]))

(def lorenz-norm (vector-norm [[-20.0 25.0] [-40.0 40.0] [0.0 60.0]]))

(def lorenz-seq-1 (norm-seq lorenz-norm lorenz-1)) 

(def lorenz-2 (runge-kutta standard-lorenz 0.01 0.0 [0.11 0.11 0.11]))

(def lorenz-seq-2 (norm-seq lorenz-norm lorenz-2))
