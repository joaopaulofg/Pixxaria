package me.jp.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import me.jp.enums.TamanhoPizza;

@Setter
@Getter
public class PizzaDTO {

   private String nome;
   private String descricao;
   private Double preco;
   @Enumerated(EnumType.STRING)
   private TamanhoPizza tamanho;

}