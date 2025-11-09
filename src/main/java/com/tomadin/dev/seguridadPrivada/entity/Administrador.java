package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_administrador;

    public Administrador(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email, Long id_administrador) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
        this.id_administrador = id_administrador;
    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }
}
