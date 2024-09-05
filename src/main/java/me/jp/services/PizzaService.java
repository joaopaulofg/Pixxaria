package me.jp.services;

import me.jp.dtos.PizzaDTO;
import me.jp.exceptions.ResourceNotFoundException;
import me.jp.models.Pizza;
import me.jp.models.PizzaPreco;
import me.jp.repositories.PizzaPrecoRepository;
import me.jp.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaPrecoRepository pizzaPrecoRepository;

    public Pizza salvar(PizzaDTO pizzaDTO) {
        if(pizzaRepository.findByNome(pizzaDTO.getNome()).isPresent()) {
            throw new IllegalArgumentException("Pizza de" + pizzaDTO.getNome() + " já cadastrada...");
        } else {
            Pizza novaPizza = Pizza.fromPizzaDTO(pizzaDTO);
            return salvarPrecoPizza(novaPizza);
        }
    }

    public List<Pizza> listarTodas() {
        return pizzaRepository.findAll();
    }

    public Pizza detalharPizza(Integer idPizza) {
        return pizzaRepository.findById(idPizza).orElseThrow(() -> new ResourceNotFoundException("Pizza nao encontrada com o ID " + idPizza));
    }

    public Pizza deletarPizza(Integer idPizza) {
        if(pizzaRepository.findById(idPizza).isPresent()) {

            Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(() -> new ResourceNotFoundException("Pizza não encontrada"));

            pizza.setDisponivel(false);
            pizzaRepository.save(pizza);
            return pizza;
        } else {
            throw new ResourceNotFoundException("Pizza nao encontrada com o ID " + idPizza);
        }
    }

    public Pizza atualizarPizza(Integer idPizza, PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(() -> new ResourceNotFoundException("Pizza não encontrada"));

        PizzaPreco precoAtual = pizzaPrecoRepository.findByPizzaAndDataFimIsNull(pizza);
        precoAtual.setDataFim(LocalDate.now());
        pizzaPrecoRepository.save(precoAtual);

        pizza.setNome(pizzaDTO.getNome());
        pizza.setDescricao(pizzaDTO.getDescricao());
        pizza.setPreco(pizzaDTO.getPreco());
        pizza.setTamanho(pizzaDTO.getTamanho());

        return salvarPrecoPizza(pizza);
    }

    private Pizza salvarPrecoPizza(Pizza pizza) {
        pizza = pizzaRepository.save(pizza);

        PizzaPreco novoPreco = new PizzaPreco();
        novoPreco.setPizza(pizza);
        novoPreco.setNome(pizza.getNome());
        novoPreco.setPreco(pizza.getPreco());
        novoPreco.setDataInicio(LocalDate.now());

        pizzaPrecoRepository.save(novoPreco);

        return pizza;
    }
}
