package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos_supervisor")
@DiscriminatorValue("SUPERVISOR")
public class TurnoSupervisor extends Turno{

    @ManyToOne //supervisor asignado a trabajar este turno
    @JoinColumn(name = "id_supervisor_asignado", referencedColumnName = "id_persona")
    private Supervisor supervisorAsignado;

    public TurnoSupervisor(LocalTime hora_comienzo, LocalTime hora_finalizacion, String nombre_turno, LocalDate fecha, EstadoTurno estadoTurno, Supervisor supervisorAsignado) {
        super(hora_comienzo, hora_finalizacion, nombre_turno, fecha, estadoTurno);
        this.supervisorAsignado = supervisorAsignado;
    }

    public Supervisor getSupervisorAsignado() {
        return supervisorAsignado;
    }

    public void setSupervisorAsignado(Supervisor supervisorAsignado) {
        this.supervisorAsignado = supervisorAsignado;
    }
}
