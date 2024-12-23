package com.lp.service;

import com.lp.model.Paciente;
import com.lp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    
    @Transactional(readOnly = true)
    public List<Paciente> buscarPacientesPorCodigo(Iterable<Long> codigo) {
        return pacienteRepository.findAllById(codigo);
    }
}
