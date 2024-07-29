package me.dio.models;

import jakarta.persistence.*;
import me.dio.dtos.PizzaDTO;
import me.dio.enums.TamanhoPizza;

@Entity
public class Pizza {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private TamanhoPizza tamanho;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    private boolean disponivel = true;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TamanhoPizza getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoPizza tamanho) {
        this.tamanho = tamanho;
    }

    public static Pizza fromPizzaDTO(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setNome(pizzaDTO.getNome());
        pizza.setDescricao(pizzaDTO.getDescricao());
        pizza.setPreco(pizzaDTO.getPreco());
        pizza.setTamanho(pizzaDTO.getTamanho());
        return pizza;
    }
}

