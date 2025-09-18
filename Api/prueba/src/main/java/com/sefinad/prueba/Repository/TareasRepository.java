package com.sefinad.prueba.Repository;

import com.sefinad.prueba.Model.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<Tarea, Long> {
}

