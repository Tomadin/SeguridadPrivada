package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "certificados_antecedentes_penales")
public class CertificadoAntecedentesPenales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_certificadoAntecedentesPenales;
    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    private Persona persona;

    private LocalDate fechaEmision;

    private LocalDate fechaVencimiento;


    public CertificadoAntecedentesPenales() {
    }

    public CertificadoAntecedentesPenales(LocalDate fechaEmision, LocalDate fechaVencimiento) {
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;

    }

    public long getId_certificadoAntecedentesPenales() {
        return id_certificadoAntecedentesPenales;
    }

    public void setId_certificadoAntecedentesPenales(long id_certificadoAntecedentesPenales) {
        this.id_certificadoAntecedentesPenales = id_certificadoAntecedentesPenales;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFecha_emision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fecha_vencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    @PrePersist
    @PreUpdate
    private void validar() {
        if (fechaVencimiento == null || fechaEmision == null) {
            throw new IllegalStateException("Las fechas no pueden ser nulas");
        }
        if (fechaVencimiento.isBefore(fechaEmision) || fechaVencimiento.isEqual(fechaEmision)) {
            throw new IllegalStateException("Fecha de vencimiento debe ser posterior a emisión");
        }
    }
}
