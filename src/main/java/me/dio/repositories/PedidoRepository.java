package me.dio.repositories;

import me.dio.models.Pedido;
import me.dio.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    //List<Pedido> findByCliente(Cliente cliente);

    List<Pedido> findByUser(User user);
}
