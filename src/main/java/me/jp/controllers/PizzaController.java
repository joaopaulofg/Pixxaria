package me.jp.controllers;

import me.jp.dtos.PizzaDTO;
import me.jp.models.Pizza;
import me.jp.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
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

    @GetMapping("/{idPizza}")
    public ResponseEntity<Pizza> consultarPizza(@PathVariable Integer idPizza) {
        try {
            Pizza pizzaProcurada = pizzaService.detalharPizza(idPizza);
            return ResponseEntity.ok(pizzaProcurada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Pizza> deletarPizza(@PathVariable Integer idPizza) {
        try {
            pizzaService.deletarPizza(idPizza);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<Pizza> atualizarPizza(@PathVariable Integer idPizza, @RequestBody PizzaDTO pizzaDTO) {
        try {
            Pizza pizzaAtualizada = pizzaService.atualizarPizza(idPizza, pizzaDTO);
            return ResponseEntity.ok(pizzaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
