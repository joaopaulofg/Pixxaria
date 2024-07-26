package me.dio.services;

import me.dio.dtos.PedidoDTO;
import me.dio.dtos.PedidoItemDTO;
import me.dio.enums.Status;
import me.dio.exceptions.ResourceNotFoundException;
import me.dio.models.Cliente;
import me.dio.models.Pedido;
import me.dio.models.PedidoItem;
import me.dio.models.Pizza;
import me.dio.repositories.ClienteRepository;
import me.dio.repositories.PedidoRepository;
import me.dio.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId()).orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + pedidoDTO.getClienteId() + " nao cadastrado."));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<PedidoItem> itens = new ArrayList<>();

        for(PedidoItemDTO pedidoItemDTO : pedidoDTO.getItens()) {
            Pizza pizza = pizzaRepository.findById(pedidoItemDTO.getPizzaId()).orElseThrow(() -> new ResourceNotFoundException("Pizza com id " + pedidoItemDTO.getPizzaId() + " nao cadstrada."));
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setPizza(pizza);
            pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
            pedidoItem.setPedido(pedido);
            itens.add(pedidoItem);
        }

        pedido.setItens(itens);
        pedido.setStatus(Status.PREPARANDO);
        pedido.setDataCriacao(new Date());
        pedido.setValorTotal(calculaValorTotal(itens));

        return pedidoRepository.save(pedido);
    }

    private Double calculaValorTotal(List<PedidoItem> itens) {
        return itens.stream().mapToDouble(item -> item.getPizza().getPreco() * item.getQuantidade()).sum();
    }
}
