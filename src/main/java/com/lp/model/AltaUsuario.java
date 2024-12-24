package com.lp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AltaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;
    private String apaterno;
    private String amaterno;
    private String password;
    private String email;
    private int id_laboratorio;
    private String numerocliente;
    private String telefonocelular;
    private String nickname;
    private boolean activo;
    private String f_alta;
    private String f_actualiza;
    private String ip;
    private String usuario_actualiza;
    private String estatus;

    // Getters y setters
}
