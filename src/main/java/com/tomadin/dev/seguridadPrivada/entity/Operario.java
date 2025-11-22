package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoTurno;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("OPERARIO")
public class Operario extends Persona{
    private EstadoTurno estado;

    @Column(name = "id_dispositivo")
    private Long id_dispositivo;

    @OneToMany(mappedBy = "operario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrabajaEn> asignacionesBarrio = new ArrayList<>();

    public Operario() {
    }

    public Operario(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email, String estado) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
        this.estado = EstadoTurno.ACTIVO;
    }

    public Operario(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email, String estado, Long id_dispositivo) {
        super(dni, cuil, nombre, apellido, edad, telefonoPersonal, email);
        this.estado = EstadoTurno.ACTIVO;
        this.id_dispositivo = id_dispositivo;
    }

    // Método helper para agregar asignación de barrio
    public void asignarBarrio(Barrio barrio, LocalDate fechaAsignacion) {
        TrabajaEn trabajaEn = new TrabajaEn(this, barrio, fechaAsignacion);
        asignacionesBarrio.add(trabajaEn);
        barrio.getAsignacionesOperarios().add(trabajaEn);
    }

    // Método helper para remover asignación de barrio
    public void desasignarBarrio(Barrio barrio) {
        TrabajaEn trabajaEnARemover = asignacionesBarrio.stream()
                .filter(te -> te.getBarrio().equals(barrio))
                .findFirst()
                .orElse(null);

        if (trabajaEnARemover != null) {
            asignacionesBarrio.remove(trabajaEnARemover);
            barrio.getAsignacionesOperarios().remove(trabajaEnARemover);
            trabajaEnARemover.setOperario(null);
            trabajaEnARemover.setBarrio(null);
        }
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public Long getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(Long id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public List<TrabajaEn> getAsignacionesBarrio() {
        return asignacionesBarrio;
    }

    public void setAsignacionesBarrio(List<TrabajaEn> asignacionesBarrio) {
        this.asignacionesBarrio = asignacionesBarrio;
    }
}
