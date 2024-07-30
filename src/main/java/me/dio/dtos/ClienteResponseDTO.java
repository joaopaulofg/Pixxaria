package me.dio.dtos;

import lombok.Getter;
import me.dio.models.Cliente;

@Getter
public class ClienteResponseDTO {

    private String nome;
    private String email;

    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.nome = cliente.getNome();
        clienteResponseDTO.email = cliente.getEmail();
        return clienteResponseDTO;
    }

}
