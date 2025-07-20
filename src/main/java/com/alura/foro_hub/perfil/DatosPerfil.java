package com.alura.foro_hub.perfil;

import jakarta.validation.constraints.NotNull;

public record DatosPerfil(
        @NotNull
        String nombre) {
}
