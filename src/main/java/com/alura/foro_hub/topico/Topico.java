package com.alura.foro_hub.topico;

import com.alura.foro_hub.curso.Curso;
import com.alura.foro_hub.repository.UsuarioRepository;
import com.alura.foro_hub.respuesta.Respuesta;
import com.alura.foro_hub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario usuario;
    @ManyToOne
    private Curso curso;
    @Transient
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datos, Usuario usuario,Curso curso) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = true;
        this.usuario = usuario;
        this.curso = curso;
        this.respuestas = null;

    }
}
