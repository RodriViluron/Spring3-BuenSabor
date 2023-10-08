package com.Spring3Pimienta.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Producto extends Base {

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private Double precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private Double precioCosto;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    private boolean eliminado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_detalle_producto")
    private List<DetalleProducto> detalleProducto = new ArrayList<DetalleProducto>();

    public void agregarDetalleProducto(DetalleProducto detalle){
        detalleProducto.add(detalle);
    }


}
