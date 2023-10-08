package com.Spring3Pimienta.Spring3.entities;

import com.Spring3Pimienta.Spring3.enums.EstadoPedido;
import com.Spring3Pimienta.Spring3.enums.FormaPago;
import com.Spring3Pimienta.Spring3.enums.TipoEnvio;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private double totalPedido;

    @NotNull
    @Column(name = "total_costo", precision = 10, scale = 2)
    private double totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    private boolean eliminado;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne()
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
