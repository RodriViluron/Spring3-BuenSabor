package com.Spring3Pimienta.Spring3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Spring3Pimienta.Spring3.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
