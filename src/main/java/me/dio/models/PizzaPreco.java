package me.dio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class PizzaPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    @JsonIgnore
    private Pizza pizza;

    private String nome;
    private Double preco;

    @JsonIgnore
    private LocalDate dataInicio;
    @JsonIgnore
    private LocalDate dataFim;

}
