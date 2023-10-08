package com.Spring3Pimienta.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Ingrediente extends Base {

    @NotNull
    private String denominacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "precio_compra", precision = 10, scale = 2)
    private double precioCompra;

    @NotNull
    @Column(name = "stock_actual", precision = 10, scale = 2)
    private double stockActual;

    @NotNull
    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private double stockMinimo;

    private boolean eliminado;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;



}
