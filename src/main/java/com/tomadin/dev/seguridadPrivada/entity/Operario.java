package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("OPERARIO")
public class Operario extends Persona{
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_actual", nullable = false)
    private EstadoOperario estadoActual = EstadoOperario.ACTIVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrio barrio;

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
    private List<AsignacionOrden> asignacionesOrden = new ArrayList<>();

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
    private List<AsignacionTurno> asignacionesTurno = new ArrayList<>();

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
    private List<AsignacionTarea> asignacionesTarea = new ArrayList<>();

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
    private List<AsignacionDispositivo> asignacionesDispositivo = new ArrayList<>();

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
    private List<Incidente> incidentes = new ArrayList<>();



}
