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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    @Builder.Default
    private List<Producto> producto = new ArrayList<>();

    public void agregarProducto(Producto prod) {
        producto.add(prod);
    }
}
