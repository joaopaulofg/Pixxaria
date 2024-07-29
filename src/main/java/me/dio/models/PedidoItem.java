package me.dio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "pizza_preco_id", nullable = false)
    private PizzaPreco pizza;

    private Integer quantidade;

    public PizzaPreco getPizza() {
        return pizza;
    }

    public void setPizza(PizzaPreco pizzaPreco) {
        this.pizza = pizzaPreco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
