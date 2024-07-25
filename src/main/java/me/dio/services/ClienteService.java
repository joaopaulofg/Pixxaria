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

    public Cliente salvar(ClienteDTO cliente) {
        if(clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            return null;
        } else {
            Cliente novoCliente = new Cliente();
            novoCliente.setCpf(cliente.getCpf());
            novoCliente.setEmail(cliente.getEmail());
            novoCliente.setNome(cliente.getNome());
            novoCliente.setEndereco(cliente.getEndereco());
            novoCliente.setSenha(cliente.getSenha());
            novoCliente.setTelefone(cliente.getTelefone());
            return clienteRepository.save(novoCliente);
        }
    }
}
