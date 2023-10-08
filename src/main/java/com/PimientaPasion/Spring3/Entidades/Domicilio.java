package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends Base{

    private String calle;
    private String numero;
    private String localidad;
    private boolean eliminado;

}
