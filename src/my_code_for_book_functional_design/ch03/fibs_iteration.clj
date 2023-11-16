(ns my-code-for-book-functional-design.ch03.fibs-iteration)

(defn fibs-work [n i fs]
  (if (= i n)
    fs
    (fibs-work n (inc i) (conj fs (apply + (take-last 2 fs))))))

(defn fibs [n]
  (cond
    (< n 1) []
    (= n 1) [1]
    :else (fibs-work n 2 [1 1])))

(defn -main [& args]
  (println (fibs 15)))

(-main)