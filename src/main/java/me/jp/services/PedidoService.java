package me.jp.services;

import me.jp.dtos.pedido.PedidoDTO;
import me.jp.dtos.pedido.PedidoItemDTO;
import me.jp.dtos.pedido.PedidoResponseDTO;
import me.jp.enums.Status;
import me.jp.exceptions.ResourceNotFoundException;
import me.jp.models.user.User;
import me.jp.models.Pedido;
import me.jp.models.PedidoItem;
import me.jp.models.Pizza;
import me.jp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaPrecoRepository precoRepository;
    @Autowired
    private PizzaPrecoRepository pizzaPrecoRepository;

    public PedidoResponseDTO criarPedido(PedidoDTO pedidoDTO) {
        User user = userRepository.findById(pedidoDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + pedidoDTO.getUserId() + " nao cadastrado."));

        Pedido pedido = new Pedido();
        pedido.setUser(user);

        List<PedidoItem> itens = new ArrayList<>();

        for(PedidoItemDTO pedidoItemDTO : pedidoDTO.getItens()) {
            Pizza pizza = pizzaRepository.findById(pedidoItemDTO.getPizzaId()).orElseThrow(() -> new ResourceNotFoundException("Pizza com id " + pedidoItemDTO.getPizzaId() + " nao cadstrada."));
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setPizza(pizzaPrecoRepository.findByPizzaAndDataFimIsNull(pizza));
            pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
            pedidoItem.setPedido(pedido);
            itens.add(pedidoItem);
        }

        pedido.setItens(itens);
        pedido.setStatus(Status.PREPARANDO);
        pedido.setDataCriacao(new Date());
        pedido.setValorTotal(calculaValorTotal(itens));
        pedidoRepository.save(pedido);

        return new PedidoResponseDTO(user.getLogin(), user.getNome(), itens, pedido.getStatus(), pedido.getValorTotal());
    }

    private Double calculaValorTotal(List<PedidoItem> itens) {
        return itens.stream().mapToDouble(item -> item.getPizza().getPreco() * item.getQuantidade()).sum();
    }

    public List<PedidoDTO> historicoCliente(User user) {
        List<Pedido> pedidos = pedidoRepository.findByUser(user);
        return pedidos.stream().map(PedidoDTO::fromEntity).collect(Collectors.toList());
    }

    public PedidoResponseDTO atualizarPedido(Integer idPedido, Status novoStatus) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new ResourceNotFoundException("Pedido com id " + idPedido + " nao encontrado."));
        System.out.println(novoStatus);
        pedido.setStatus(novoStatus);
        System.out.println(pedido.getStatus());
        pedidoRepository.save(pedido);
        return new PedidoResponseDTO(pedido.getUser().getLogin(), pedido.getUser().getNome(), pedido.getItens(), pedido.getStatus(), pedido.getValorTotal());
    }

    public PedidoResponseDTO consultarPedido(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new ResourceNotFoundException("Pedido nao encontrado."));

        return new PedidoResponseDTO(pedido.getUser().getLogin(), pedido.getUser().getNome(), pedido.getItens(), pedido.getStatus(), pedido.getValorTotal());
    }
}
