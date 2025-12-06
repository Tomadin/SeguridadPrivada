package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Persona{
    @ManyToMany
    @JoinTable(
            name = "administrador_barrio",
            joinColumns = @JoinColumn(name = "id_administrador"),
            inverseJoinColumns = @JoinColumn(name = "id_barrio")
    )
    private List<Barrio> barriosGestiona = new ArrayList<>();

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<OrdenServicio> ordenesCreadas = new ArrayList<>();

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<AsignacionTurno> turnosAsignados = new ArrayList<>();

    public Administrador(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
    }

    public List<Barrio> getBarriosGestiona() {
        return barriosGestiona;
    }

    public void setBarriosGestiona(List<Barrio> barriosGestiona) {
        this.barriosGestiona = barriosGestiona;
    }

    public void addBarrio(Barrio barrio){
        this.barriosGestiona.add(barrio);
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
