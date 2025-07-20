package com.alura.foro_hub.usuario;

import com.alura.foro_hub.perfil.DatosPerfil;
import com.alura.foro_hub.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;


    /*
    @ManyToMany
    @JoinTable(
            name = "usuario_perfiles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )

     */
    @Transient
    private List<DatosPerfil> perfiles;

    public Usuario(DatosUsuario usuario) {
        this.id = null;
        this.nombre = usuario.nombre();
        this.correoElectronico = usuario.correoElectronico();
        this.contrasena = null;

    }


}
