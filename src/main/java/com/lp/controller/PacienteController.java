package com.lp.controller;

import com.lp.model.Paciente;
import com.lp.service.PacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.constraints.NotEmpty; 
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = LogManager.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "nuevo_paciente";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid @ModelAttribute Paciente paciente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.warn("Validation errors while submitting form: {}", result.getAllErrors());
            return "nuevo_paciente";
        }
        pacienteService.guardarPaciente(paciente);
        logger.info("Paciente guardado exitosamente: {}", paciente);
        return "redirect:/pacientes/nuevo?success";
        
        
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<String> buscarPacientes(@RequestParam List<Long> ids) {
        Iterable<Long> idsIterable = ids; // Suponiendo que obtienes ids de alguna fuente
        
        if (!idsIterable.iterator().hasNext()) {
            // El iterable está vacío
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontraron pacientes.");
        } else {
            // El iterable no está vacío
            // Aquí va la lógica para manejar los ids encontrados
            return ResponseEntity.ok("Pacientes encontrados.");
        }
    }
}
