package com.lp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.model.AltaUsuario;

@Repository
public interface AltaUsuarioRepository extends JpaRepository<AltaUsuario, Long> {
}