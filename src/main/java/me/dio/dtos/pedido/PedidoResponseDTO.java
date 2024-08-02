package me.dio.dtos.pedido;

import me.dio.dtos.UserResponseDTO;
import me.dio.models.Pedido;
import me.dio.models.PedidoItem;

import java.util.List;

public class PedidoResponseDTO {

    private UserResponseDTO user;
    private List<PedidoItem> itens;

    public PedidoResponseDTO(UserResponseDTO user, List<PedidoItem> itens) {
        this.user = user;
        this.itens = itens;
    }



}
