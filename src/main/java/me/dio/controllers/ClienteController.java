package me.dio.controllers;

import me.dio.dtos.ClienteCreateDTO;
import me.dio.dtos.ClienteResponseDTO;
import me.dio.dtos.PedidoDTO;
import me.dio.exceptions.ResourceNotFoundException;
import me.dio.models.*;
import me.dio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody @Valid ClienteCreateDTO cliente) {
        try{
            ClienteResponseDTO novoCliente = clienteService.salvar(cliente);
            return ResponseEntity.ok(novoCliente);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> consultarHistorico(@PathVariable Integer idCliente) {
        try {
            List<PedidoDTO> historico = clienteService.consultarHistoricoPedidos(idCliente);
            return ResponseEntity.ok(historico);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}