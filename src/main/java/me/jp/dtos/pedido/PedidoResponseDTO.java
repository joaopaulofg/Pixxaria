package me.jp.dtos.pedido;

import lombok.Getter;
import lombok.Setter;
import me.jp.models.PedidoItem;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoResponseDTO {

    private String nomeUsuario;
    private String loginUsuario;
    private  List<PedidoItemResponseDTO> itensPedido = new ArrayList<>();

    public PedidoResponseDTO(String login, String nome, List<PedidoItem> itens) {
        this.loginUsuario = login;
        this.nomeUsuario = nome;
        for (PedidoItem item : itens) {
            this.itensPedido.add(
                    PedidoItemResponseDTO.fromEntity(item)
            );
        }
    }
}
