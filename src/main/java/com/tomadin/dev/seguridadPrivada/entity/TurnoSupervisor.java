package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue("TURNOS_SUPERVISOR")
public class TurnoSupervisor extends Turno {

    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    private Supervisor supervisorAsignado;

    public TurnoSupervisor() {
    }

    public TurnoSupervisor(LocalTime hora_comienzo, LocalTime hora_finalizacion, String nombre_turno, LocalDate fecha, EstadoTurno estadoTurno) {
        super(hora_comienzo, hora_finalizacion, nombre_turno, fecha, estadoTurno);
    }

    public Supervisor getSupervisorAsignado() {
        return supervisorAsignado;
    }

    public void setSupervisorAsignado(Supervisor supervisorAsignado) {
        this.supervisorAsignado = supervisorAsignado;
    }
}