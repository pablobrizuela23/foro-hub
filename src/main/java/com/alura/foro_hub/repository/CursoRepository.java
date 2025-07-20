package com.alura.foro_hub.repository;

import com.alura.foro_hub.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
