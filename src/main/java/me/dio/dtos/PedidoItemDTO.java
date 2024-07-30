package me.dio.dtos;

import me.dio.models.PedidoItem;

import java.util.List;

public class PedidoItemDTO {
    private Integer pizzaId;
    private String pizzaNome;
    private Integer quantidade;

    public PedidoItemDTO fromEntity(PedidoItem pedidoItem) {
        this.quantidade = pedidoItem.getQuantidade();
        this.pizzaNome = pedidoItem.getPizza().getNome();
        this.pizzaId = pedidoItem.getPizza().getId();
        return this;
    }

    public String getPizzaNome() {
        return pizzaNome;
    }

    public void setPizzaNome(String pizzaNome) {
        this.pizzaNome = pizzaNome;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
