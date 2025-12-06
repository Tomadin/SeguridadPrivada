package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Registros_repriv")
public class RegistroRepriv {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_registroRepriv;
    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    private Persona persona;
    private String numero_registro;

    private LocalDate fecha_registro;

    private LocalDate fecha_vencimiento;
    private estadoRegistroRepriv estado;

    public RegistroRepriv() {
    }

    public RegistroRepriv( String numero_registro, LocalDate fecha_registro, LocalDate fecha_vencimiento, estadoRegistroRepriv estado) {
        this.numero_registro = numero_registro;
        this.fecha_registro = fecha_registro;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
    }

    public Long getId_registroRepriv() {
        return id_registroRepriv;
    }

    public void setId_registroRepriv(Long id_registroRepriv) {
        this.id_registroRepriv = id_registroRepriv;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(String numero_registro) {
        this.numero_registro = numero_registro;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public estadoRegistroRepriv getEstado() {
        return estado;
    }

    public void setEstado(estadoRegistroRepriv estado) {
        this.estado = estado;
    }
}
