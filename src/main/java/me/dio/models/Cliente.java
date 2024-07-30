package me.dio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import me.dio.dtos.ClienteCreateDTO;

@Setter
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;

    public static Cliente fromDTO(ClienteCreateDTO clienteDTO) {
        Cliente novoCliente = new Cliente();
        novoCliente.setCpf(clienteDTO.getCpf());
        novoCliente.setEmail(clienteDTO.getEmail());
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setEndereco(clienteDTO.getEndereco());
        novoCliente.setSenha(clienteDTO.getSenha());
        novoCliente.setTelefone(clienteDTO.getTelefone());
        return novoCliente;
    }
}
