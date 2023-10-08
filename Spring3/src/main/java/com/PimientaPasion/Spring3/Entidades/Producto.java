package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto extends Base{

    private float precioVenta;
    private float precioCosto;
    private int tiempoPreparacion;
    private String descripcion;
    private String urlImagen;
    private int cantidadVendida;
    private String denominacion;
    private boolean eliminado;


}
