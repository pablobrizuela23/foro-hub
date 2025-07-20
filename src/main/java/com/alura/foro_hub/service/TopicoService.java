package com.alura.foro_hub.service;

import com.alura.foro_hub.curso.Curso;
import com.alura.foro_hub.repository.CursoRepository;
import com.alura.foro_hub.repository.UsuarioRepository;
import com.alura.foro_hub.topico.*;
import com.alura.foro_hub.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    public void registrar(DatosRegistroTopico datos) {
        Boolean existe = topicoRepository.existsByTituloAndMensaje(datos.titulo(),datos.mensaje());

        if (existe) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
        }

        if (datos.idUsuario() == null) {
            throw new IllegalArgumentException("El idUsuario no puede ser null");
        }
        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        Curso curso = cursoRepository.getReferenceById(datos.idCurso());
        topicoRepository.save(new Topico(datos,usuario,curso));

    }

    @Transactional
    public void actualizar(Long id,DatosActualizarTopico datos) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()){
            throw new EntityNotFoundException("No se encontro el topico con ID: " +id);

        }

        Topico topico = optionalTopico.get();
        //evito duplicados
        Boolean existeDuplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(),datos.mensaje());

        if (existeDuplicado &&
                (!topico.getTitulo().equals(datos.titulo()) || !topico.getMensaje().equals(datos.mensaje()))) {
            throw new IllegalArgumentException("Ya existe otro tópico con el mismo título y mensaje.");
        }



        if (datos.titulo()!=null){
            topico.setTitulo(datos.titulo());
        }
        if (datos.mensaje()!=null){
            topico.setMensaje(datos.mensaje());
        }
        if (datos.idCurso()!=null){
            Curso curso = cursoRepository.getReferenceById(datos.idCurso());
            topico.setCurso(curso);
        }


    }

    public Page<DatosListaTopicos> listar(Pageable paginacion) {
        //findAll recibe un Page<Topico>
        return topicoRepository.findAll(paginacion)
                .map(DatosListaTopicos::new);//esto convierte cada topico en un DTO
    }

    public DatosDetallesTopico detalle(Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));
        return new DatosDetallesTopico(topico);
    }

    public Boolean eliminar(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()){
            Topico topico = topicoOptional.get();
            topico.setStatus(false);
            topicoRepository.save(topico);
            return true;
        }else {
            return false;
        }
    }
}
