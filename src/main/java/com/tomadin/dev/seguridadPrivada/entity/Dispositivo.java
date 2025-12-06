package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dispositivos")
@Data
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String telefono;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String anioFabricacion;

    @Column(name = "sistema_operativo", nullable = false, length = 50)
    private String sistemaOperativo;

    @Column(name = "ultima_vez_activo")
    private LocalDateTime ultimaVezActivo;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "dispositivo", cascade = CascadeType.ALL)
    private List<AsignacionDispositivo> asignaciones = new ArrayList<>();


    @Column(name = "ultimo_nivel_bateria")
    private Integer ultimoNivelBateria;

    @Column(name = "ultima_actualizacion_bateria")
    private LocalDateTime ultimaActualizacionBateria;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDate.now();
    }

    public Dispositivo() {
    }

    public Dispositivo(String telefono, String modelo, String anioFabricacion, String sistemaOperativo) {
        this.telefono = telefono;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.sistemaOperativo = sistemaOperativo;
        this.fechaCreacion = LocalDate.now();
    }

    public Long getId() {
        return id;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public LocalDateTime getUltimaVezActivo() {
        return ultimaVezActivo;
    }

    public void setUltimaVezActivo(LocalDateTime ultimaVezActivo) {
        this.ultimaVezActivo = ultimaVezActivo;
    }

    public Integer getUltimoNivelBateria() {
        return ultimoNivelBateria;
    }

    public void setUltimoNivelBateria(Integer ultimoNivelBateria) {
        this.ultimoNivelBateria = ultimoNivelBateria;
    }

    public LocalDateTime getUltimaActualizacionBateria() {
        return ultimaActualizacionBateria;
    }

    public void setUltimaActualizacionBateria(LocalDateTime ultimaActualizacionBateria) {
        this.ultimaActualizacionBateria = ultimaActualizacionBateria;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<AsignacionDispositivo> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionDispositivo> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public void addAsignacion(AsignacionDispositivo asignacion){
        this.asignaciones.add(asignacion);
    }


}
