package me.dio.services;

import me.dio.dtos.ClienteDTO;
import me.dio.exceptions.ResourceNotFoundException;
import me.dio.models.Cliente;
import me.dio.models.Pedido;
import me.dio.repositories.ClienteRepository;
import me.dio.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Cliente salvar(ClienteDTO clienteDTO) {
        if(clienteRepository.findByCpf(clienteDTO.getCpf()).isPresent()){
            throw new ResourceNotFoundException("Cliente com o CPF " + clienteDTO.getCpf() + " já existe");
        } else {
            Cliente cliente = Cliente.fromDTO(clienteDTO);
            return clienteRepository.save(cliente);
        }
    }

    public List<Pedido> consultarHistoricoPedidos(Integer idCliente) {
        if(clienteRepository.findById(idCliente).isEmpty()){
            throw new ResourceNotFoundException("Cliente com o ID " + idCliente + " nao encontrado");
        } else {
            Cliente cliente = clienteRepository.findById(idCliente).get();
            return pedidoService.historicoCliente(cliente);
        }
    }
}
