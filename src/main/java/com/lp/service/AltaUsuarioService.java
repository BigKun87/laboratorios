package com.lp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.model.AltaUsuario;
import com.lp.repository.AltaUsuarioRepository;

@Service
public class AltaUsuarioService {

    @Autowired
    private AltaUsuarioRepository usuarioRepository;

    public AltaUsuario crearUsuario(AltaUsuario altausuario) {
        return usuarioRepository.save(altausuario);
    }
}
