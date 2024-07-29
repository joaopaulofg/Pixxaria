package me.dio.repositories;

import me.dio.models.Pizza;
import me.dio.models.PizzaPreco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaPrecoRepository extends JpaRepository<PizzaPreco, Integer> {
    PizzaPreco findByPizzaAndDataFimIsNull(Pizza pizza);
}
