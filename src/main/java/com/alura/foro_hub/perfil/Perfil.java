package com.alura.foro_hub.perfil;

import com.alura.foro_hub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Perfil")
@Table(name = "perfiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Transient
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios;

    public Perfil(DatosPerfil perfiles) {
        this.id = null;
        this.nombre = perfiles.nombre();
        //this.usuarios = null;
    }
}
