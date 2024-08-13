package me.jp.controllers;

import jakarta.validation.Valid;
import me.jp.dtos.pedido.PedidoDTO;
import me.jp.dtos.pedido.PedidoResponseDTO;
import me.jp.models.Pedido;
import me.jp.enums.Status;
import me.jp.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        try {
            PedidoResponseDTO pedidoCriado = pedidoService.criarPedido(pedidoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<?> consultarPedido(@PathVariable Integer idPedido) {
        try {
            PedidoDTO pedido = pedidoService.consultarPedido(idPedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<?> atualizarPedido(@PathVariable Integer idPedido, Status novoStatus) {
        try {
            Pedido pedidoAtualizado = pedidoService.atualizarPedido(idPedido, novoStatus);
            return ResponseEntity.ok(pedidoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
