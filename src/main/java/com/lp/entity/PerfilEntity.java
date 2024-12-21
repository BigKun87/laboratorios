package com.lp.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "perfil")
@Data
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_seq")
	@SequenceGenerator(name = "perfil_seq", sequenceName = "perfil_id_seq", allocationSize = 1)
	private BigInteger id;

	private String nombre;

	private String descripcion;

	@JoinTable(name = "usuario_perfil",
			joinColumns = @JoinColumn(name = "perfil", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "usuario", nullable = false),
			indexes = @Index(name = "usuario_perfil_index", columnList = "perfil, usuario", unique = true))
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserEntity> usuarios = new ArrayList<>();
}
