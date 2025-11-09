package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos_operario")
@DiscriminatorValue("OPERARIO")
public class TurnoOperario extends Turno{
    @Column(name = "id_operario")
    private Long id_operario;

    public TurnoOperario(LocalTime hora_comienzo, LocalTime hora_finalizacion, String nombre_turno, LocalDate fecha, EstadoTurno estadoTurno, Long id_operario) {
        super(hora_comienzo, hora_finalizacion, nombre_turno, fecha, estadoTurno);
        this.id_operario = id_operario;
    }

    public Long getId_operario() {
        return id_operario;
    }

    public void setId_operario(Long id_operario) {
        this.id_operario = id_operario;
    }
}
