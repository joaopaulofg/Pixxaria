package me.dio.services;

import me.dio.dtos.ClienteCreateDTO;
import me.dio.dtos.ClienteResponseDTO;
import me.dio.dtos.PedidoDTO;
import me.dio.exceptions.ResourceNotFoundException;
import me.dio.models.Cliente;
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

    public ClienteResponseDTO salvar(ClienteCreateDTO clienteDTO) {
        if(clienteRepository.findByCpf(clienteDTO.getCpf()).isPresent()){
            throw new ResourceNotFoundException("Cliente com o CPF " + clienteDTO.getCpf() + " já existe");
        } else {
            Cliente novoCliente = Cliente.fromDTO(clienteDTO);
            Cliente salvo = clienteRepository.save(novoCliente);
            return ClienteResponseDTO.fromEntity(salvo);
        }
    }

    public List<PedidoDTO> consultarHistoricoPedidos(Integer idCliente) {
        if(clienteRepository.findById(idCliente).isEmpty()){
            throw new ResourceNotFoundException("Cliente com o ID " + idCliente + " nao encontrado");
        } else {
            Cliente cliente = clienteRepository.findById(idCliente).get();
            return pedidoService.historicoCliente(cliente);
        }
    }
}
