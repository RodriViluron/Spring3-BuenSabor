package com.PimientaPasion.Spring3.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RubroIngrediente extends Base{

    private String denominacion;
    private boolean eliminado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubroIngrediente_id")// FK llamada "rubroIngrediente_id" en la tabla Producto
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();


    public void agregarProductos(Producto producto){
        productos.add(producto);
    }

}
