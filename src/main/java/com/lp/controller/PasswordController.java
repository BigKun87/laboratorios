package com.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lp.entity.PasswordChangeDTO;
import com.lp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private UserService userService;

    @GetMapping("/change")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("passwordChangeDTO", new PasswordChangeDTO());
        return "changePassword";
    }

    @PostMapping("/change")
    public String changePassword(@Valid PasswordChangeDTO passwordChangeDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "changePassword";
        }

        try {
            boolean success = userService.changePassword(
                    "user@example.com", // Reemplaza con el email del usuario actual
                    passwordChangeDTO.getCurrentPassword(),
                    passwordChangeDTO.getNewPassword()
            );

            if (success) {
                model.addAttribute("message", "Contraseña cambiada exitosamente.");
            } else {
                model.addAttribute("error", "La contraseña actual es incorrecta.");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al cambiar la contraseña.");
        }

        return "changePassword";
    }
}
