package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.estadoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id_usuario;
    private String usuario;
    private String rol;
    @Column(nullable = false)
    private String password;
    private estadoUsuario estado_usuario;
    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String usuario, String rol, String password, estadoUsuario estado_usuario) {
        this.usuario = usuario;
        this.rol = rol;
        this.password = password;
        this.estado_usuario = estado_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public estadoUsuario getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(estadoUsuario estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        if (persona != null && persona.getUsuario() != this) {
            persona.setUsuario(this);
        }
    }
}
