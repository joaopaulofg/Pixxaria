package me.dio.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import me.dio.enums.TamanhoPizza;
import me.dio.models.Pizza;

public class PizzaDTO {

   private String nome;
   private String descricao;
   private Double preco;
   @Enumerated(EnumType.STRING)
   private TamanhoPizza tamanho;

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

}