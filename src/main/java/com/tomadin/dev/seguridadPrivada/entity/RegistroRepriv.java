package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.estadoRegistroRepriv;
import jakarta.persistence.*;

import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;
    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;
    private estadoRegistroRepriv estado;

    public RegistroRepriv() {
    }

    public RegistroRepriv( String numero_registro, Date fecha_registro, Date fecha_vencimiento, estadoRegistroRepriv estado) {
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

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public estadoRegistroRepriv getEstado() {
        return estado;
    }

    public void setEstado(estadoRegistroRepriv estado) {
        this.estado = estado;
    }
}
