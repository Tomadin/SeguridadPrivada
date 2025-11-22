package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Persona{


    public Administrador() {
    }

    public Administrador(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
    }


}
