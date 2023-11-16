(ns my-code-for-book-functional-design.ch04.fibs-laziness-1)

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

; Update the -main function to use lazy-fibs and print the first 15 Fibonacci numbers
(defn -main [& args]
  (println (take 19 (lazy-fibs))))