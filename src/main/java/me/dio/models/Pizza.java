package me.dio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.dio.dtos.PizzaDTO;
import me.dio.enums.TamanhoPizza;

@Setter
@Getter
@Entity
public class Pizza {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private TamanhoPizza tamanho;

    private boolean disponivel = true;

    public static Pizza fromPizzaDTO(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setNome(pizzaDTO.getNome());
        pizza.setDescricao(pizzaDTO.getDescricao());
        pizza.setPreco(pizzaDTO.getPreco());
        pizza.setTamanho(pizzaDTO.getTamanho());
        return pizza;
    }
}

