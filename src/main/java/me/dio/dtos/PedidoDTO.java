package me.dio.dtos;

import me.dio.models.Pedido;
import me.dio.models.PedidoItem;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private Integer clienteId;
    private String clienteNome;
    private List<PedidoItemDTO> itens;

    public static PedidoDTO fromEntity(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setClienteId(pedido.getCliente().getId());
        pedidoDTO.setClienteNome(pedido.getCliente().getNome());
        List<PedidoItemDTO> itens = new ArrayList<>();

        for(PedidoItem pedidoItem : pedido.getItens()) {
            PedidoItemDTO pedidoItemDTO = new PedidoItemDTO();
            pedidoItemDTO.fromEntity(pedidoItem);
            itens.add(pedidoItemDTO);
        }
        pedidoDTO.setItens(itens);
        return pedidoDTO;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<PedidoItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItemDTO> itens) {
        this.itens = itens;
    }
}
