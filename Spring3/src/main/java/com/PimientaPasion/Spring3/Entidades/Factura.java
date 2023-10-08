package com.PimientaPasion.Spring3.Entidades;

import java.util.Date;

import com.PimientaPasion.Spring3.Enumeraciones.FormaPago;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends Base{

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
    private boolean eliminado;

    public void mostrarFactura(){
        System.out.println("Factura numero: " + numero);
        System.out.println("Forma de pago: " + formaPago);
        System.out.println("Total a pagar: " + total);


    }
}
