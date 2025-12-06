package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SUPERVISOR")
@Data
@EqualsAndHashCode(callSuper = true)
public class Supervisor extends Persona {

    @ManyToMany
    @JoinTable(
            name = "supervisor_barrio",
            joinColumns = @JoinColumn(name = "id_supervisor"),
            inverseJoinColumns = @JoinColumn(name = "id_barrio")
    )
    private List<Barrio> barriosSupervisa = new ArrayList<>();

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    private List<OrdenServicio> ordenesCreadas = new ArrayList<>();

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    private List<AsignacionTurno> turnosAsignados = new ArrayList<>();

    public Supervisor(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
    }

    public List<Barrio> getBarriosSupervisa() {
        return barriosSupervisa;
    }

    public void setBarriosSupervisa(List<Barrio> barriosSupervisa) {
        this.barriosSupervisa = barriosSupervisa;
    }

    public void addBarrio(Barrio barrio){
        this.barriosSupervisa.add(barrio);
    }

    public List<OrdenServicio> getOrdenesCreadas() {
        return ordenesCreadas;
    }

    public void setOrdenesCreadas(List<OrdenServicio> ordenesCreadas) {
        this.ordenesCreadas = ordenesCreadas;
    }

    public void addOrdenesCreadas(OrdenServicio orden){
        this.ordenesCreadas.add(orden);
    }
    public List<AsignacionTurno> getTurnosAsignados() {
        return turnosAsignados;
    }

    public void setTurnosAsignados(List<AsignacionTurno> turnosAsignados) {
        this.turnosAsignados = turnosAsignados;
    }

    public void addTurnosAsignados(AsignacionTurno turno){
        this.turnosAsignados.add(turno);
    }
}
