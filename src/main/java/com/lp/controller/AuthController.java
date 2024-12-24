package com.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lp.model.User;
import com.lp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.saveUser(user);
            model.addAttribute("message", "Usuario registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al cifrar la contraseña.");
        }
        return "register";
    }
}
