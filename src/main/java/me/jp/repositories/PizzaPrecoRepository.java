package me.jp.repositories;

import me.jp.models.Pizza;
import me.jp.models.PizzaPreco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaPrecoRepository extends JpaRepository<PizzaPreco, Integer> {
    PizzaPreco findByPizzaAndDataFimIsNull(Pizza pizza);
}
