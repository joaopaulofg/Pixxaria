package me.dio.services;

import me.dio.dtos.ClienteDTO;
import me.dio.models.Cliente;
import me.dio.repositories.ClienteRepository;
import me.dio.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Cliente salvar(ClienteDTO clienteDTO) {
        if(clienteRepository.findByCpf(clienteDTO.getCpf()).isPresent()){
            throw new IllegalArgumentException("Cliente com o CPF " + clienteDTO.getCpf() + " já existe");
        } else {
            Cliente cliente = Cliente.fromDTO(clienteDTO);
            return clienteRepository.save(cliente);
        }
    }
}
