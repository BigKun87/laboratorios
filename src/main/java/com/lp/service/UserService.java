package com.lp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.model.User;
import com.lp.repository.UserlgRepository;

@Service
public class UserService {

    @Autowired
    private UserlgRepository userRepository;

    @Autowired
    private AES256EncryptionService encryptionService;

    public void saveUser(User user) throws Exception {
        String encryptedPassword = encryptionService.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

