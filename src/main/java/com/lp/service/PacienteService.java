package com.lp.service;

import com.lp.model.Paciente;
import com.lp.repository.PacienteRepository;

import dto.PacienteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

   /* public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }*/
    
    public void guardarPaciente(PacienteDTO pacienteDTO) throws IOException {
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setObservaciones(pacienteDTO.getObservaciones());

        MultipartFile archivo = pacienteDTO.getArchivo_pdf();
        if (archivo != null && !archivo.isEmpty()) {
            paciente.setArchivo_pdf(archivo.getBytes());
        }

        pacienteRepository.save(paciente);
    }
    
    @Transactional(readOnly = true)
    public List<Paciente> buscarPacientesPorCodigo(Iterable<Long> codigo) {
        return pacienteRepository.findAllById(codigo);
    }
}
