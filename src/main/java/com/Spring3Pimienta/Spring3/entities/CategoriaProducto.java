package com.Spring3Pimienta.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class CategoriaProducto extends Base {

    @NotNull
    private String denominacion;

    private boolean eliminado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_producto")
    private List<Producto> producto = new ArrayList<Producto>();

    public void agregarProducto(Producto prod) {
        producto.add(prod);

    }
}
