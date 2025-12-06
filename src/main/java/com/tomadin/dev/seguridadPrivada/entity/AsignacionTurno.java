package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoAsignacion;
import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "asignaciones_tarea")
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AsignacionTurno extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea", nullable = false)
    private Tarea tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operario", nullable = false)
    private Operario operario;

    @Column(name = "hora_inicio_real")
    private LocalDateTime horaInicioReal;

    @Column(name = "hora_fin_real")
    private LocalDateTime horaFinReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTurno estado = EstadoTurno.PLANIFICADO;

    @Column(columnDefinition = "TEXT")
    private String novedades;

    @Column(columnDefinition = "TEXT")
    private String resultado;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_supervisor_asignado", referencedColumnName = "id_persona", nullable = false)
    private Supervisor supervisorAsignado;

    public AsignacionTurno() {

    }

    public AsignacionTurno(Operario operario, LocalDateTime horaInicioReal, LocalDateTime horaFinReal, Supervisor supervisorAsignado) {
        this.operario = operario;
        this.horaInicioReal = horaInicioReal;
        this.horaFinReal = horaFinReal;
        this.supervisorAsignado = supervisorAsignado;
        this.estado = EstadoTurno.PLANIFICADO;
    }

    public Long getId() {
        return id;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public LocalDateTime getHoraInicioReal() {
        return horaInicioReal;
    }

    public void setHoraInicioReal(LocalDateTime horaInicioReal) {
        this.horaInicioReal = horaInicioReal;
    }

    public LocalDateTime getHoraFinReal() {
        return horaFinReal;
    }

    public void setHoraFinReal(LocalDateTime horaFinReal) {
        this.horaFinReal = horaFinReal;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Supervisor getSupervisorAsignado() {
        return supervisorAsignado;
    }

    public void setSupervisorAsignado(Supervisor supervisorAsignado) {
        this.supervisorAsignado = supervisorAsignado;
    }
}
