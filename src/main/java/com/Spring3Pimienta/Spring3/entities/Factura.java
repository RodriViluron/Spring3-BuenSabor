package com.Spring3Pimienta.Spring3.entities;

import com.Spring3Pimienta.Spring3.enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Factura extends Base {

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private int numeroFactura;

    @Column(name = "mp_merchant_order_id")
    private Double porcentajeDescuento;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    private Double totalCosto;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private Double totalVenta;

    private boolean eliminado;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_detalle_factura")
    private List<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();

    public void agregarDetalleFactura(DetalleFactura detalle) {
        detalleFactura.add(detalle);
    }
}
