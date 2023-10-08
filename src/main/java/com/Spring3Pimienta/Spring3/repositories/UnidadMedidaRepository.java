package com.Spring3Pimienta.Spring3.repositories;

import com.Spring3Pimienta.Spring3.entities.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Long>{
}
