package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoBarrio;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barrios")
public class Barrio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_barrio;
    private String nombre_barrio;
    private String codigo_postal;
    private EstadoBarrio estado;
    @OneToMany(mappedBy = "barrio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrabajaEn> asignacionesOperarios  = new ArrayList<>();


    public Barrio(String nombre_barrio, String codigo_postal, EstadoBarrio estado) {
        this.nombre_barrio = nombre_barrio;
        this.codigo_postal = codigo_postal;
        this.estado = estado;
    }

    public Long getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(Long id_barrio) {
        this.id_barrio = id_barrio;
    }

    public String getNombre_barrio() {
        return nombre_barrio;
    }

    public void setNombre_barrio(String nombre_barrio) {
        this.nombre_barrio = nombre_barrio;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public EstadoBarrio getEstado() {
        return estado;
    }

    public void setEstado(EstadoBarrio estado) {
        this.estado = estado;
    }

    public List<TrabajaEn> getAsignacionesOperarios() {
        return asignacionesOperarios;
    }

    public void setAsignacionesOperarios(List<TrabajaEn> asignacionesOperarios) {
        this.asignacionesOperarios = asignacionesOperarios;
    }

}
