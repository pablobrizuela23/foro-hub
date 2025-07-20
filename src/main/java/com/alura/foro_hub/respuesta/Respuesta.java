package com.alura.foro_hub.respuesta;

import com.alura.foro_hub.topico.DatosRegistroTopico;
import com.alura.foro_hub.usuario.DatosUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.time.LocalDate;
public class Respuesta {
    private Long id;
    private String mensaje;
    private DatosRegistroTopico topico;
    private LocalDate fechaCreacion;
    private DatosUsuario autor;
    private String solucion;
}
