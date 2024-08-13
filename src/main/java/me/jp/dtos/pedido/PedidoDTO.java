package me.jp.dtos.pedido;

import lombok.Getter;
import lombok.Setter;
import me.jp.models.Pedido;
import me.jp.models.PedidoItem;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PedidoDTO {
    private Integer userId;
    private List<PedidoItemDTO> itens;

    public static PedidoDTO fromEntity(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setUserId(pedido.getUser().getId());
        List<PedidoItemDTO> itens = new ArrayList<>();

        for(PedidoItem pedidoItem : pedido.getItens()) {
            PedidoItemDTO pedidoItemDTO = new PedidoItemDTO();
            pedidoItemDTO.fromEntity(pedidoItem);
            itens.add(pedidoItemDTO);
        }
        pedidoDTO.setItens(itens);
        return pedidoDTO;
    }

}
