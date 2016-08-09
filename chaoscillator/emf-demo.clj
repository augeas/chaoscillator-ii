
(use 'chaoscillator.seqs)
(use 'chaoscillator.sounds)

(def b1 (seqbuff lorenz-seq-1 1024 16))
(def b2 (seqbuff lorenz-seq-2 1024 16))

(defn do-demo [] (do (bsin-1 400 100 20 20 0.25(b1 0) (b1 1) (b1 2)) (bsin-2 300 80 30 20 0.25 (b2 0) (b2 1))))
