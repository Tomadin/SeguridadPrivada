package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Persona {
    @Id
    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    protected Long id_persona;
    @Column(unique = true, nullable = false)
    protected String dni;
    @Column(unique = true, nullable = false)
    protected String cuil;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String telefonoPersonal;
    @Column(unique = true, nullable = false)

    protected String email;

    @OneToOne(cascade = CascadeType.ALL) // para guardar y eliminar Direccion junto a Persona
    @JoinColumn(name = "id_direccion") // refiere PK de Direccion
    protected Direccion direccion;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    protected Usuario usuario;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    protected CertificadoAntecedentesPenales certificadoAntecedentesPenales;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    protected RegistroRepriv registroRepriv;

    public Persona() {
    }

    public Persona(String dni, String cuil, String nombre, String apellido, int edad, String telefonoPersonal, String email) {
        this.dni = dni;
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefonoPersonal = telefonoPersonal;
        this.email = email;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        if (direccion != null && direccion.getPersona() != this) {
            direccion.setPersona(this);
        }
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null && usuario.getPersona() != this) {
            usuario.setPersona(this);
        }
    }

    public CertificadoAntecedentesPenales getCertificadoAntecedentesPenales() {
        return certificadoAntecedentesPenales;
    }

    public void setCertificadoAntecedentesPenales(CertificadoAntecedentesPenales certificado) {
        this.certificadoAntecedentesPenales = certificado;
        if (certificado != null && certificado.getPersona() != this) {
            certificado.setPersona(this);
        }
    }

    public RegistroRepriv getRegistroRepriv() {
        return registroRepriv;
    }

    public void setRegistroRepriv(RegistroRepriv registro) {
        this.registroRepriv = registro;
        if (registro != null && registro.getPersona() != this) {
            registro.setPersona(this);
        }
    }
}
