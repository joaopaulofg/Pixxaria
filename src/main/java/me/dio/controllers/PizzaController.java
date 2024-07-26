package me.dio.controllers;

import me.dio.dtos.PizzaDTO;
import me.dio.models.Pizza;
import me.dio.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> cadastrarPizza(@RequestBody PizzaDTO pizzaDTO) {
        try {
            Pizza novaPizza = pizzaService.salvar(pizzaDTO);
            return ResponseEntity.ok(novaPizza);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> listarPizzas() {
        List<Pizza> pizzasCadastradas;
        pizzasCadastradas = pizzaService.listarTodas();
        return ResponseEntity.ok(pizzasCadastradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> consultarPizza(@PathVariable Integer id) {
        Pizza pizzaProcurada = pizzaService.detalhes(id);
        return ResponseEntity.ok(pizzaProcurada);
    }
}
