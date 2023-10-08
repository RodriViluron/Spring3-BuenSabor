package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnidadMedida extends Base{
    private String denominacion;
    private String abreviatura;
    private boolean eliminado;

}
