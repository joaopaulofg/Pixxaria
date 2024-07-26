package me.dio.controllers;

import me.dio.dtos.ClienteDTO;
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
    public ResponseEntity<?> registrarCliente(@RequestBody @Valid ClienteDTO cliente) {
        try{
            Cliente novoCliente = clienteService.salvar(cliente);
            return ResponseEntity.ok(novoCliente);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarHistorico(@PathVariable Integer id) {
        try {
            List<Pedido> historico = clienteService.consultarHistoricoPedidos(id);
            return ResponseEntity.ok(historico);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}