package me.dio.dtos;

import lombok.Getter;
import lombok.Setter;
import me.dio.models.Cliente;

@Setter
@Getter
public class ClienteCreateDTO {

    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;

    public ClienteCreateDTO fromEntity(Cliente cliente ) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        return this;
    }

}

