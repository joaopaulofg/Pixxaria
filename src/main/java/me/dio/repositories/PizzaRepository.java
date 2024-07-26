package me.dio.repositories;

import me.dio.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {

    Optional<Pizza> findByNome(String nome);

}
