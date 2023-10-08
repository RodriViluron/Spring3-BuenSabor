package com.Spring3Pimienta.Spring3.repositories;

import com.Spring3Pimienta.Spring3.entities.DetalleProducto;
import com.Spring3Pimienta.Spring3.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto,Long> {
}
