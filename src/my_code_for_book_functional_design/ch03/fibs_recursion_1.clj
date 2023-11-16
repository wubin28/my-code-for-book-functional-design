(ns my-code-for-book-functional-design.ch03.fibs-recursion-1)

(defn fib [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(defn fibs [n]
  (map fib (range 1 (inc n))))

(defn -main [& args]
  (println (fibs 15)))
