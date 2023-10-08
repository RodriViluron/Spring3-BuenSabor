package com.Spring3Pimienta.Spring3.repositories;

import com.Spring3Pimienta.Spring3.entities.RubroIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroIngredienteRepository extends JpaRepository<RubroIngrediente, Long> {
}
