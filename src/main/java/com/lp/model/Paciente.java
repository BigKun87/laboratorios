package com.lp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El apellido paterno no puede estar vacío")
    private String apaterno;

    @NotEmpty(message = "El apellido materno no puede estar vacío")
    private String amaterno;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El género no puede estar vacío")
    private char genero;
    
    @NotEmpty(message = "El código no puede estar vacío") 
    private String codigo;

    private String direccion;
    private String telefono;

    @Email(message = "El correo electrónico debe tener un formato válido")
    private String email;

    @Column(updatable = false)
    private LocalDate fechaRegistro;

    // Getters y setters

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDate.now();
    }
}
