package me.dio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
