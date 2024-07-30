package me.dio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import me.dio.dtos.ClienteCreateDTO;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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
