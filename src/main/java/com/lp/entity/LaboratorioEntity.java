package com.lp.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "laboratorio")
@Data
public class LaboratorioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratorio_seq")
	@SequenceGenerator(name = "laboratorio_seq", sequenceName = "laboratorio_id_seq", allocationSize = 1, initialValue = 2)
	private BigInteger id;

	private String nombre;

	@OneToMany(mappedBy = "laboratorio", fetch = FetchType.LAZY)
	private List<UserEntity> usuarios = new ArrayList<>();

	@Column(name = "estatus", length = 20)
	private String estatus;

	private LocalDateTime fechaAlta;

	private LocalDateTime fechaActualizacion;

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
