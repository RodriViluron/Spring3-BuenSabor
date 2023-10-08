package com.Spring3Pimienta.Spring3.repositories;

import com.Spring3Pimienta.Spring3.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
