package me.dio.controllers;

import me.dio.dtos.ClienteDTO;
import me.dio.models.Cliente;
import me.dio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody @Valid ClienteDTO cliente) {
        Cliente novoCliente = clienteService.salvar(cliente);

        if(novoCliente != null) {
            return ResponseEntity.ok(novoCliente);
        } else {
            return new ResponseEntity<>("CPF informado ja estah cadastrado...", HttpStatus.OK);
        }

    }

}
