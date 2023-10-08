package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedio extends Base{
    private boolean eliminado;
}
