package dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class PacienteDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String p_nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String p_apellido;

    private String email;
    private MultipartFile archivo_pdf;

    @Size(max = 200, message = "Las observaciones no pueden exceder los 200 caracteres")
    private String p_observaciones;
    
 // Getters y setters
    public String getNombre() {
        return p_nombre;
    }

    public void setNombre(String nombre) {
        this.p_nombre = nombre;
    }

    public String getApellido() {
        return p_apellido;
    }

    public void setApellido(String apellido) {
        this.p_apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getArchivo_pdf() {
        return archivo_pdf;
    }

    public void setArchivo_pdf(MultipartFile archivo_pdf) {
        this.archivo_pdf = archivo_pdf;
    }

    public String getObservaciones() {
        return p_observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.p_observaciones = observaciones;
    }
}

