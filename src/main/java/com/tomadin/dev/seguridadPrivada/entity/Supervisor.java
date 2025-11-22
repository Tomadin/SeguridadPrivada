package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SUPERVISOR")
public class Supervisor extends Persona {

    @OneToMany(mappedBy = "supervisorAsignado", cascade = CascadeType.ALL)
    private List<Turno> turnosGenerados = new ArrayList<>();

    // Turnos donde este supervisor está ASIGNADO para trabajar
    @OneToMany(mappedBy = "supervisorAsignado", cascade = CascadeType.ALL)
    private List<TurnoSupervisor> turnosAsignados = new ArrayList<>();

    public Supervisor() {
    }

    public Supervisor(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);

    }

    // Método helper para turnos generados
    public void addTurnoGenerado(Turno turno) {
        turnosGenerados.add(turno);
        turno.setSupervisorAsignado(this);
    }

    public void removeTurnoGenerado(Turno turno) {
        turnosGenerados.remove(turno);
        turno.setSupervisorAsignado(null);
    }

    // Método helper para turnos asignados
    // Método helper para turnos asignados - CORREGIDO
    public void addTurnoAsignado(TurnoSupervisor turno) {
        turnosAsignados.add(turno);
        turno.setSupervisorAsignado(this); // ✅ CORRECTO
    }

    public void removeTurnoAsignado(TurnoSupervisor turno) {
        turnosAsignados.remove(turno);
        turno.setSupervisorAsignado(null); // ✅ CORRECTO
    }
}
