package com.lp.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordChangeDTO {

    @NotBlank(message = "La contraseña actual no puede estar vacía")
    private String currentPassword;

    @NotBlank(message = "La nueva contraseña no puede estar vacía")
    @Size(min = 8, max = 20, message = "La nueva contraseña debe tener entre 8 y 20 caracteres")
    private String newPassword;

    // Getters y setters
    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}


