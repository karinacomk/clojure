(ns estoque.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor (class valor))
  15)

(println (imprime-e-15 24))

(println (map imprime-e-15 pedido))

;destruct (desistruturando o map em chave e valor)
(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  valor)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[_ valor]]                        ;_ quer dizer "nao vou usar"
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))

(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;agora com threading LAST: ,,, é a colecao em ultimo
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produtos ,,,)
      (reduce + ,,,)))

(println (total-do-pedido pedido))

;MELHOR ABORDAGEM
(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn preco-total-do-produto
  [pedido]
  (->> pedido
       vals
       (map preco-dos-produtos ,,,)
       (reduce + ,,,)))

(println (total-do-pedido pedido))

;----


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  ;(println item)
    (<= (get item :preco 0) 0))

(println "filtrando gratuitos")
(println (filter gratuito? (vals pedido)))
;---


[(defn gratuito?
  [[_ item]]
  ;(println item)
  (<= (get item :preco 0) 0))]

  (println "filtrando gratuitos")
  (println (filter gratuito? pedido))

;---
[(defn gratuito?
   [item]
   (println item)
   (<= (get item :preco 0) 0))]

(println (filter #(gratuito? (second %)) pedido))

;---

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

;---

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

;---

(def clientes [{ :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])

;Extraimos os certificados, contamos e depois somamos.
(->> clientes (map :certificados) (map count) (reduce +))


