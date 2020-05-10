(ns estoque.aula4)

(def precos [30 70 100])

(println (precos 0))
(println (get precos 0))
(println (get precos 2))
(println (get precos 17))
;(println (precos 17))
(println (get precos 17 "XX"))
(println (get precos 2 "XX"))

(println (conj precos 5))
(println precos)

(println (+ 5 1))
(println (inc 4))

(println (update precos 0 inc))
(println precos)

(defn soma+1
  [valor]
  (println "estou somando um a" valor)
  (+ valor 1))

(println (update precos 0 soma+1))
(println precos)


;AULA ANTERIOR

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(def precos [30 700 1000])
(println precos)
(println "MAP" (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))                       ;even é se é par
(println "filter" (filter aplica-desconto? precos))

;transformar uma sequencia em outra, ex somar o primeiro valor com o segundo valor
; pq nao usar map ou filter, porque eles só recebem um a um
(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))
(println (reduce minha-soma 0 precos))




