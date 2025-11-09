package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_direccion;
    private String provincia;
    private String pais;
    private String calle;
    private String piso;
    private Integer altura;
    private int depto;
    @OneToOne(mappedBy = "direccion")
    private Persona persona;

    public Direccion() {
    }

    public Direccion(String provincia, String pais, String calle, String piso, Integer altura, int depto) {
        this.provincia = provincia;
        this.pais = pais;
        this.calle = calle;
        this.piso = piso;
        this.altura = altura;
        this.depto = depto;
    }

    public long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getDepto() {
        return depto;
    }

    public void setDepto(int depto) {
        this.depto = depto;
    }
}
