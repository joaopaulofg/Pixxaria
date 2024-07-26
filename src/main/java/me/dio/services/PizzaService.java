package me.dio.services;

import me.dio.dtos.PizzaDTO;
import me.dio.models.Pizza;
import me.dio.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza salvar(PizzaDTO pizzaDTO) {
        if(pizzaRepository.findByNome(pizzaDTO.getNome()).isPresent()) {
            throw new IllegalArgumentException("Pizza de" + pizzaDTO.getNome() + " já cadastrada...");
        } else {
            Pizza pizza = Pizza.fromPizzaDTO(pizzaDTO);
            return  pizzaRepository.save(pizza);
        }
    }

    public List<Pizza> listarTodas() {
        return pizzaRepository.findAll();
    }

    public Pizza detalhes(Integer id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza nao encontrada com o ID " + id));
    }
}
