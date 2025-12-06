package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoOrden;
import com.tomadin.dev.seguridadPrivada.enums.PrioridadOrden;
import com.tomadin.dev.seguridadPrivada.enums.TipoCreador;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "ordenes_servicio",
        indexes = {
                @Index(name = "idx_numero_orden", columnList = "numero_orden"),
                @Index(name = "idx_estado", columnList = "estado"),
                @Index(name = "idx_fecha_creacion", columnList = "fecha_creacion")
        }
)
@Data
@EqualsAndHashCode(callSuper = true)
public class OrdenServicio extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_orden", nullable = false, unique = true, length = 50)
    private String numeroOrden;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoOrden estado = EstadoOrden.CREADA;

    @Column(name = "descripcion_general", columnDefinition = "TEXT")
    private String descripcionGeneral;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadOrden prioridad = PrioridadOrden.MEDIA;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_creador", nullable = false)
    private TipoCreador tipoCreador;

    // Relación polimórfica según tipoCreador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private Supervisor supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrio barrio;

    @OneToMany(mappedBy = "ordenServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas = new ArrayList<>();

    @OneToMany(mappedBy = "ordenServicio", cascade = CascadeType.ALL)
    private List<AsignacionOrden> asignaciones = new ArrayList<>();

    public OrdenServicio() {
    }

    public OrdenServicio(String descripcionGeneral, TipoCreador tipoCreador, Supervisor supervisor, Administrador administrador, Barrio barrio, List<Tarea> tareas, List<AsignacionOrden> asignaciones) {
        this.descripcionGeneral = descripcionGeneral;
        this.tipoCreador = tipoCreador;
        this.supervisor = supervisor;
        this.administrador = administrador;
        this.barrio = barrio;
        this.tareas = tareas;
        this.asignaciones = asignaciones;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public PrioridadOrden getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadOrden prioridad) {
        this.prioridad = prioridad;
    }

    public TipoCreador getTipoCreador() {
        return tipoCreador;
    }

    public void setTipoCreador(TipoCreador tipoCreador) {
        this.tipoCreador = tipoCreador;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<AsignacionOrden> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionOrden> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
