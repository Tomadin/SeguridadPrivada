package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "turnos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_turno", discriminatorType = DiscriminatorType.STRING)
public abstract class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id_turno;

    protected LocalTime hora_comienzo;
    protected LocalTime hora_finalizacion;
    protected String nombre_turno;
    protected LocalDate fecha;
    @Enumerated(EnumType.STRING)
    protected EstadoTurno estadoTurno;

    @ManyToOne
    @JoinColumn(name = "id_supervisor_asignado", referencedColumnName = "id_persona", nullable = false)
    private Supervisor supervisorAsignado;
    /*
    @ManyToOne
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
    private Barrio barrio;
*/

    public Turno(LocalTime hora_comienzo, LocalTime hora_finalizacion, String nombre_turno, LocalDate fecha, EstadoTurno estadoTurno) {
        this.hora_comienzo = hora_comienzo;
        this.hora_finalizacion = hora_finalizacion;
        this.nombre_turno = nombre_turno;
        this.fecha = fecha;
        this.estadoTurno = estadoTurno;
    }

    public Turno() {

    }


    public LocalTime getHora_comienzo() {
        return hora_comienzo;
    }

    public void setHora_comienzo(LocalTime hora_comienzo) {
        this.hora_comienzo = hora_comienzo;
    }

    public LocalTime getHora_finalizacion() {
        return hora_finalizacion;
    }

    public void setHora_finalizacion(LocalTime hora_finalizacion) {
        this.hora_finalizacion = hora_finalizacion;
    }

    public String getNombre_turno() {
        return nombre_turno;
    }

    public void setNombre_turno(String nombre_turno) {
        this.nombre_turno = nombre_turno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public Supervisor getSupervisorAsignado() {
        return supervisorAsignado;
    }

    public void setSupervisorAsignado(Supervisor supervisorAsignado) {
        this.supervisorAsignado = supervisorAsignado;
    }


}
