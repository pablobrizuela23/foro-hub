package com.alura.foro_hub.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @Transient
    private String categoria;

    public Curso(Curso curso) {
        this.id = null;
        this.nombre = curso.nombre;
        //this.categoria = curso.categoria;
    }
}
