package me.dio.dtos;

import java.util.List;

public class PedidoDTO {
    private Integer clienteId;
    private List<PedidoItemDTO> itens;

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
