package me.dio.dtos.pedido;

import lombok.Getter;
import lombok.Setter;
import me.dio.models.PedidoItem;

@Setter
@Getter
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

}
