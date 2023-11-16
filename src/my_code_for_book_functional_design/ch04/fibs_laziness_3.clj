(ns my-code-for-book-functional-design.ch04.fibs-laziness-3)

(declare fib)

(defn fib-w [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(def fib (memoize fib-w))

; Define the lazy-fibs function to generate a lazy sequence of Fibonacci numbers
(defn lazy-fibs []
  (map fib (rest (range))))

(def list-of-fibs (lazy-fibs))

(defn -main [& args]
  (println (take 20 list-of-fibs)))