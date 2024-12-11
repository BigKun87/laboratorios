package com.lp.controller;

import com.lp.entity.UserEntity;
import com.lp.model.User;
import com.lp.repository.UserRepository;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UserController {

	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "usuarios";
    }
	
	@PostMapping("/guardar")
	public String guardaUsuario(@Valid UserEntity user, BindingResult result) {
		if (result.hasErrors()) {
            return "register";
        }
        
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword())); 

		userRepository.save(user);
		return "redirect:/login";
	}

}
