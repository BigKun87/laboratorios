package com.lp.controller;

import com.lp.model.Paciente;
import com.lp.service.PacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
}
