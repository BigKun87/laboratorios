package com.lp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lp.model.Paciente;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	List<Paciente> findAllByCodigo(String codigo);
}
