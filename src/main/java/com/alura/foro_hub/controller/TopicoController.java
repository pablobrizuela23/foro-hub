package com.alura.foro_hub.controller;

import com.alura.foro_hub.service.TopicoService;
import com.alura.foro_hub.topico.DatosActualizarTopico;
import com.alura.foro_hub.topico.DatosDetallesTopico;
import com.alura.foro_hub.topico.DatosListaTopicos;
import com.alura.foro_hub.topico.DatosRegistroTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

@Autowired
private TopicoService topicoService;

    @Transactional
    @PostMapping
    public void registraTopico(@RequestBody @Valid DatosRegistroTopico datos){
        topicoService.registrar(datos);
    }


    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(
            @PathVariable Long id,
            @RequestBody DatosActualizarTopico datos){
        topicoService.actualizar(id,datos);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Page<DatosListaTopicos> listarTopicos(
            @PageableDefault(
            size = 10, sort = "fechaCreacion", direction = Direction.ASC)
            Pageable paginacion) {
        return topicoService.listar(paginacion);
    }

    @GetMapping("/{id}")
    public DatosDetallesTopico detallesTopico(@PathVariable Long id){
        return topicoService.detalle(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Boolean eliminado = topicoService.eliminar(id);
        if (eliminado){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
