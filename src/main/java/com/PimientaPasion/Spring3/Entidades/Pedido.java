package com.PimientaPasion.Spring3.Entidades;

import com.PimientaPasion.Spring3.Enumeraciones.Estado;
import com.PimientaPasion.Spring3.Enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends Base{


    private Estado estado;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;
    private boolean eliminado;


    //Relacion 1a1 con Factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id") //FK "factura_id"
    private Factura factura;


    //Generacion de tabla intermedia "detallePedido" para la relacion N*M con la tabla Productos
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "detallePedido",
            joinColumns = @JoinColumn (name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
//Se pueden producir ERRORES DE RECURSIVIDAD por eso excluimos los metodos Equals and HashCode
    @EqualsAndHashCode.Exclude
//Si o si tenemos que colocar @Builder.Default sino da error
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProductos(Producto producto){
        productos.add(producto);
    }



}

