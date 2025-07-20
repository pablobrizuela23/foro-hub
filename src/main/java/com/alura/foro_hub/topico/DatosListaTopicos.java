package com.alura.foro_hub.topico;

import java.time.LocalDate;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        Boolean status,
        String usuario,
        String curso) {

    public DatosListaTopicos(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
