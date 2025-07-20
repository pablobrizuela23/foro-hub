package com.alura.foro_hub.usuario;

import com.alura.foro_hub.perfil.DatosPerfil;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosUsuario(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank @Email
        @JsonAlias(value = "correo_electronico") String correoElectronico,
        @Transient
        DatosPerfil perfiles) {
}
