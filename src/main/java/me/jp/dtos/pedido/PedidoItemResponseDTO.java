package me.jp.dtos.pedido;

import lombok.Getter;
import lombok.Setter;
import me.jp.models.PedidoItem;

@Getter
@Setter
public class PedidoItemResponseDTO {

    private String pizzaNome;
    private Integer quantidade;

    public static PedidoItemResponseDTO fromEntity(PedidoItem pedidoItem) {
        PedidoItemResponseDTO pedidoItemResponseDTO = new PedidoItemResponseDTO();
        pedidoItemResponseDTO.quantidade = pedidoItem.getQuantidade();
        pedidoItemResponseDTO.pizzaNome = pedidoItem.getPizza().getNome();
        return pedidoItemResponseDTO;
    }
}
