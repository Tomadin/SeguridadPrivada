package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.estadoCertificadoAntecedentesPenales;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "certificados_antecedentes_penales")
public class CertificadoAntecedentesPenales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_certificadoAntecedentesPenales;
    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    private Persona persona;
    @Temporal(TemporalType.DATE)
    private Date fecha_emision;
    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;
    private estadoCertificadoAntecedentesPenales estado;

    public CertificadoAntecedentesPenales() {
    }

    public CertificadoAntecedentesPenales(Date fecha_emision, Date fecha_vencimiento, estadoCertificadoAntecedentesPenales estado) {
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
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

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public estadoCertificadoAntecedentesPenales getEstado() {
        return estado;
    }

    public void setEstado(estadoCertificadoAntecedentesPenales estado) {
        this.estado = estado;
    }
}
