(ns my-code-for-book-functional-design.ch03.fibs-iteration-3)

(declare fib)

(defn fib-w [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(def fib (memoize fib-w))

(defn ifib
  ([n a b]
   (if (= 0 n)
     b
     (recur (dec n) b (+ a b))))

  ([n]
   (cond
     (< n 1) nil
     (<= n 2) 1
     :else (ifib (- n 2) 1 1)))
  )

(defn fibs [n]
  (map ifib (range 1 (inc n))))

(defn -main [& args]
  (println (fibs 17)))
