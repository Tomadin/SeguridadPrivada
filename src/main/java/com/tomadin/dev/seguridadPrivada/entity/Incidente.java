package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoIncidente;
import com.tomadin.dev.seguridadPrivada.enums.GravedadIncidente;
import com.tomadin.dev.seguridadPrivada.enums.TipoIncidente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidentes")
@Data
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoIncidente tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GravedadIncidente gravedad;

    @Column
    private Float latitud;

    @Column
    private Float longitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operario", nullable = false)
    private Operario operario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrio barrio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;

    @Column(name = "reportado_por", nullable = false)
    private Long reportadoPor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoIncidente estado;

    @PrePersist
    protected void onCreate() {
        fechaHora = LocalDateTime.now();
    }

    public Incidente() {
    }

    public Incidente(LocalDateTime fechaHora, String descripcion, TipoIncidente tipo, GravedadIncidente gravedad, Float latitud, Float longitud, Operario operario, Barrio barrio, Tarea tarea, Long reportadoPor) {
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.operario = operario;
        this.barrio = barrio;
        this.tarea = tarea;
        this.reportadoPor = reportadoPor;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIncidente getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidente tipo) {
        this.tipo = tipo;
    }

    public GravedadIncidente getGravedad() {
        return gravedad;
    }

    public void setGravedad(GravedadIncidente gravedad) {
        this.gravedad = gravedad;
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

    public EstadoIncidente getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidente estado) {
        this.estado = estado;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Long getReportadoPor() {
        return reportadoPor;
    }

    public void setReportadoPor(Long reportadoPor) {
        this.reportadoPor = reportadoPor;
    }
}
