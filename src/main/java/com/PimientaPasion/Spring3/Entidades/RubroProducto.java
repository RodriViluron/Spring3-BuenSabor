package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RubroProducto extends Base{
    private String denominacion;

    private boolean eliminado;
}
