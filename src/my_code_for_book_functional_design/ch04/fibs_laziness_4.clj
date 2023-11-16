(ns my-code-for-book-functional-design.ch04.fibs-laziness-4)

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

; Define real-list-of-fibs to get the first 21 Fibonacci numbers
(def real-list-of-fibs (doall (take 21 (lazy-fibs))))

(def list-of-fibs (lazy-fibs))

(defn -main [& args]
  (println (take 21 list-of-fibs))
  ; Optionally, you can also print real-list-of-fibs to see the same result
  (println real-list-of-fibs))