package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue("TURNOS_OPERARIO")
public class TurnoOperario extends Turno {

    @ManyToOne
    @JoinColumn(name = "id_operario")
    private Operario operario;

    public TurnoOperario() {}

    public TurnoOperario(LocalTime hora_comienzo, LocalTime hora_finalizacion, String nombre_turno,
                         LocalDate fecha, EstadoTurno estadoTurno, Operario operario) {

        super(hora_comienzo, hora_finalizacion, nombre_turno, fecha, estadoTurno);
        this.operario = operario;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }
}
