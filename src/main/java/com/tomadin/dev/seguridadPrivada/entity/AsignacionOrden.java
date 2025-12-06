package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoAsignacionOrden;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones_orden")
@Data
public class AsignacionOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_servicio", nullable = false)
    private OrdenServicio ordenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operario", nullable = false)
    private Operario operario;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "fecha_aceptacion")
    private LocalDateTime fechaAceptacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsignacionOrden estado = EstadoAsignacionOrden.PENDIENTE;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "asignado_por", nullable = false)
    private Long asignadoPor; //cambiar

    @PrePersist
    protected void onCreate() {
        fechaAsignacion = LocalDateTime.now();
    }

    public AsignacionOrden() {
    }

    public AsignacionOrden(OrdenServicio ordenServicio, Operario operario, LocalDateTime fechaAceptacion, String observaciones, Long asignadoPor) {
        this.ordenServicio = ordenServicio;
        this.operario = operario;
        this.fechaAsignacion = LocalDateTime.now();
        this.fechaAceptacion = fechaAceptacion;
        this.observaciones = observaciones;
        this.asignadoPor = asignadoPor;
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

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDateTime getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(LocalDateTime fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public EstadoAsignacionOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignacionOrden estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getAsignadoPor() {
        return asignadoPor;
    }

    public void setAsignadoPor(Long asignadoPor) {
        this.asignadoPor = asignadoPor;
    }
}

