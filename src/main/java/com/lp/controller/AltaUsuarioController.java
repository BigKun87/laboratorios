package com.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lp.model.AltaUsuario;
import com.lp.service.AltaUsuarioService;

@RestController
@RequestMapping("/usuarios")

public class AltaUsuarioController {

    @Autowired
    private AltaUsuarioService altausuarioService;

    @PostMapping("/alta")
    public ResponseEntity<AltaUsuario> crearUsuario(@RequestBody AltaUsuario altausuario) {
        AltaUsuario nuevoUsuario = altausuarioService.crearUsuario(altausuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
