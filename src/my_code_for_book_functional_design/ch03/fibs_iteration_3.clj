(ns my-code-for-book-functional-design.ch03.fibs-iteration-3)

(declare fib)

(defn fib-w [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(def fib (memoize fib-w))

(defn -main [& args]
  (println (map fib (range 1 18))))
