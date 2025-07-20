package com.alura.foro_hub.topico;

import com.alura.foro_hub.curso.Curso;
import com.alura.foro_hub.usuario.DatosUsuario;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @JsonAlias(value = "autor_id") Long idUsuario,
        @NotNull
        @JsonAlias(value = "curso_id") Long idCurso

) {
}
