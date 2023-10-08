package com.Spring3Pimienta.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class DetalleFactura extends Base {

    @NotNull
    private Integer cantidad;

    @ManyToOne()
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;



}
