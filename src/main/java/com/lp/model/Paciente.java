package com.lp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.security.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String p_nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String p_apellido;

    private String p_email;

    @Lob
    private byte[] p_archivo_pdf;

    @Size(max = 200, message = "Las observaciones no pueden exceder los 200 caracteres")
    private String p_observaciones;

    private Timestamp f_alta;
    private Timestamp f_actualiza;
    private String ip;
    private String usuario_actualiza;
    private String estatus;

    // Getters y setters
    
    public Long getId_paciente() {
        return p_id;
    }

    public void setId_paciente(Long id_paciente) {
        this.p_id = id_paciente;
    }

    public String getNombre() {
        return p_nombre;
    }

    public void setNombre(String nombre) {
        this.p_nombre = nombre;
    }

    public String getApellido() {
        return p_apellido;
    }

    public void setApellido(String apellido) {
        this.p_apellido = apellido;
    }

    public String getEmail() {
        return p_email;
    }

    public void setEmail(String email) {
        this.p_email = email;
    }

    public byte[] getArchivo_pdf() {
        return p_archivo_pdf;
    }

    public void setArchivo_pdf(byte[] archivo_pdf) {
        this.p_archivo_pdf = archivo_pdf;
    }

    public String getObservaciones() {
        return p_observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.p_observaciones = observaciones;
    }

    public Timestamp getF_alta() {
        return f_alta;
    }

    public void setF_alta(Timestamp f_alta) {
        this.f_alta = f_alta;
    }

    public Timestamp getF_actualiza() {
        return f_actualiza;
    }

    public void setF_actualiza(Timestamp f_actualiza) {
        this.f_actualiza = f_actualiza;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsuario_actualiza() {
        return usuario_actualiza;
    }

    public void setUsuario_actualiza(String usuario_actualiza) {
        this.usuario_actualiza = usuario_actualiza;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
