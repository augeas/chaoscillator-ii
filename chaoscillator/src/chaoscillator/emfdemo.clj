(def bv1 (seqbuff lorenz-seq-1 1024 16))

(def bv2 (seqbuff lorenz-seq-2 1024 16))

(do (bsin-1 440 100 20 20 0.25 (bv1 0) (bv1 1) (bv1 2)) (bsin-1 300 80 30 30 0.25 (bv2 0) (bv2 1) (bv2 2)))
