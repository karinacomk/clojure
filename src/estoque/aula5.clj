(ns estoque.aula5)

(def estoque {"Mochila" 10,
              "Camiseta" 5})

(println estoque)

(println "temos" (count estoque) "elementos")
(println "Chave" (keys estoque))                            ;nao existe garantia na ordem
(println "Valores" (vals estoque))

(def estoque {:mochila 10,
              :camiseta 5})
(println (assoc estoque :cadeira 3))
(println (assoc estoque :mochila 1))
(println (update estoque :mochila inc))
(println (update estoque :mochila #(- % 3)))
(println (dissoc estoque :mochila))

;-----

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
(println (get pedido :mochila))
(println (get pedido :cadeira 0))
(println (:mochila pedido))                                 ;:mochila invoca ifn
(println (:cadeira pedido {}))                              ;mais comum

(println (:quantidade (:mochila pedido)))
(println (update-in pedido [:mochila :quantidade] inc))


(println (:quantidade (:mochila pedido)))

;THREADING (ENCADEANDO, "fiozinho de costura") "tredin" FORMA MAIS USADA DO Q OUTRA
;THREADING FIRST ,,,
(println (-> pedido
             :mochila
             :quantidade))

;pedido.get (mochila).get (quantidade)

; nao tao bom de usar
(-> pedido
    :mochila
    :quantidade
    println)

(def clientes { :15 { :nome "Guilherme" :certificados ["Clojure" "Java" "Machine Learning"] } })
(-> clientes :15 :certificados count)

