package com.lp.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;



import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "usuarios_id_seq", allocationSize = 1, initialValue = 2)
	private BigInteger id;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	@NotEmpty
	@Email
	private String email;

	@Column(name = "password", nullable = false, length = 100)
	@NotEmpty
	private String password;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@Column(name = "apaterno", nullable = false, length = 20)
	private String apellidoPaterno;

	@Column(name = "amaterno", nullable = false, length = 20)
	private String apellidoMaterno;

	@Column(name = "numerocliente", nullable = false, length = 50)
	private String numeroCliente;

	@Column(name = "numerocelular", length = 20)
	private String celular;

	@Column(name = "nickname", length = 15)
	private String nickname;

	@Column(name = "activo", nullable = false)
	private Boolean activo;

	@Column(name = "f_alta", nullable = false)
	private LocalDateTime fechaAlta;

	@Column(name = "f_actualiza", nullable = false)
	private LocalDateTime fechaActualizacion;

	@Column(name = "ip", length = 45)
	private String ip;

	@Column(name = "usuario_actualiza", length = 15)
	private String updatedBy;

	@Column(name = "estatus", length = 20)
	private String estatus;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private PerfilEntity perfil;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private LaboratorioEntity laboratorio;

	@PrePersist
	public void prePersist() {
		fechaAlta = LocalDateTime.now();
		// TODO: obtener el usuario de la sesión
	}

	@PreUpdate
	public void preUpdate() {
		fechaActualizacion = LocalDateTime.now();
		// TODO: Obtener el usuario de la sesión.
	}
}