

(use 'overtone.core)

(defsynth pulse-1 [freq 440 width 0.5 cut 1000] (out 0 (lpf (pulse freq width) cut))) 

(definst bpulse-1 [freq 440 d 100 r 1.0 b1 0 b2 1 b3 2] (
  pan2 (pulse (+ freq (* d (play-buf:kr 1 b2 r))) (play-buf:kr 1 b3 r)) (- (* 2 (play-buf:kr 1 b1 r)) 1.0)
))

(definst bpulse-2 [freq 440 fd 100 cut 1000 r 1.0 b1 0 b2 1 b3 2] (
  pan2 (lpf (pulse (+ freq (* fd (play-buf:kr 1 b2 r)))) (* cut (play-buf:kr 1 b3 r))) (- (* 2 (play-buf:kr 1 b1 r)) 1.0)
))

(definst bsaw-1 [freq 440 fd 100 cut 1000 r 1.0 b1 0 b2 1 b3 2] (
  pan2 (lpf (saw (+ freq (* fd (play-buf:kr 1 b2 r)))) (* cut (play-buf:kr 1 b3 r))) (- (* 2 (play-buf:kr 1 b1 r)) 1.0)
))

(definst bsin-1 [freq 440 fd 100 lf 20 ld 20 r 1.0 b1 0 b2 1 b3 2] (
  pan2 (sin-osc (* (+ freq (* fd (play-buf:kr 1 b2 r))) (sin-osc (+ lf (* fd (play-buf:kr 1 b3 r)))))) (- (* 2 (play-buf:kr 1 b1 r)) 1.0)
))


(defn zipseq [s] (apply (partial map vector) s))

(defn blkbuff [bv sq blk n i] (
  let [data (zipseq (take blk sq)) j (inc i) p (* blk i)]
  (if (< j n) (do
    (mapv #(buffer-write! %1 p %2) bv data)
    (blkbuff bv (drop blk sq) blk n j)
  ) bv)
))  

(defn seqbuff [sq blk n] (
  let [c (count (first sq)) bv (mapv buffer (repeat c (* n blk)))]
  (blkbuff bv sq blk n 0)
))


