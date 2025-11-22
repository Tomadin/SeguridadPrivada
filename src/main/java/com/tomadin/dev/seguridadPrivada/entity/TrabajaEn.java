package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trabajaEn")
public class TrabajaEn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_trabajaEn;
    @ManyToOne
    @JoinColumn(name = "id_operario", nullable = false)
    private Operario operario;
    @ManyToOne
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio", nullable = false)
    private Barrio barrio;
    private EstadoTurno estado;

    @Column(name = "fecha_asignacion")
    private LocalDate fecha_asignacion;

    public TrabajaEn() {
    }

    public TrabajaEn(Operario operario, Barrio barrio, LocalDate fecha_asignacion) {
        this.operario = operario;
        this.barrio = barrio;
        this.fecha_asignacion = fecha_asignacion;
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

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(LocalDate fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }
}
