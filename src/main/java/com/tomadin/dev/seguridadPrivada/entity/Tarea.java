package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTarea;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tareas")
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_servicio", nullable = false)
    private OrdenServicio ordenServicio;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Integer prioridad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTarea estado = EstadoTarea.PENDIENTE;

    @Column(nullable = false)
    private Float latitud;

    @Column(nullable = false)
    private Float longitud;

    @Column(name = "tipo_tarea", nullable = false, length = 100)
    private String tipoTarea;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<FotoTarea> fotos = new ArrayList<>();

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<AsignacionTarea> asignaciones = new ArrayList<>();

    @OneToMany(mappedBy = "tarea")
    private List<Incidente> incidentes = new ArrayList<>();

    public Tarea() {
    }

    public Tarea(OrdenServicio ordenServicio, String descripcion, Integer prioridad, String tipoTarea) {
        this.ordenServicio = ordenServicio;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipoTarea = tipoTarea;
    }

    public Long getId() {
        return id;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public List<FotoTarea> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoTarea> fotos) {
        this.fotos = fotos;
    }

    public List<AsignacionTarea> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionTarea> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
}
