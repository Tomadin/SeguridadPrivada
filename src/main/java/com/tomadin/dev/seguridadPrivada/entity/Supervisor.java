package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supervisores")
public class Supervisor extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_supervisor;
    @OneToMany(mappedBy = "supervisorCreador", cascade = CascadeType.ALL)
    private List<Turno> turnosGenerados = new ArrayList<>();

    // Turnos donde este supervisor está ASIGNADO para trabajar
    @OneToMany(mappedBy = "supervisorAsignado", cascade = CascadeType.ALL)
    private List<TurnoSupervisor> turnosAsignados = new ArrayList<>();

    public Supervisor(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email, Long id_supervisor) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
        this.id_supervisor = id_supervisor;
    }

    // Método helper para turnos generados
    public void addTurnoGenerado(Turno turno) {
        turnosGenerados.add(turno);
        turno.setSupervisorCreador(this);
    }

    public void removeTurnoGenerado(Turno turno) {
        turnosGenerados.remove(turno);
        turno.setSupervisorCreador(null);
    }

    // Método helper para turnos asignados
    public void addTurnoAsignado(TurnoSupervisor turno) {
        turnosAsignados.add(turno);
        turno.setSupervisorAsignado(this);
    }

    public void removeTurnoAsignado(TurnoSupervisor turno) {
        turnosAsignados.remove(turno);
        turno.setSupervisorAsignado(null);
    }
}
