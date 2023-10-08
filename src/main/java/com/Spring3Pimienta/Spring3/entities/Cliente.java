package com.Spring3Pimienta.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cliente extends Base {

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private boolean eliminado;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    //Relación OneToMany Cliente y Domicilio
     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
     @JoinColumn(name = "fk_cliente")
     @Builder.Default
     private List<Domicilio> domicilios = new ArrayList<>();

    //-----------------------------------------------------------------------------------
    //Métodos
    public void agregarUsuario(Usuario usuario){

        this.usuario = usuario;
    }
    public void agregarDomicilio(Domicilio dom){

        domicilios.add(dom);
    }

    public void mostrarDomicilios() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle());
            System.out.println("Número: " + domicilio.getNumero());
            System.out.println("Código Postal:" + domicilio.getCodigoPostal());
            System.out.println("Localidad: " + domicilio.getLocalidad());
            System.out.println("Número Departamento: " + domicilio.getNumeroDpto());
            System.out.println("Piso Departamento: " + domicilio.getNumeroDpto());
        }
    }



}
