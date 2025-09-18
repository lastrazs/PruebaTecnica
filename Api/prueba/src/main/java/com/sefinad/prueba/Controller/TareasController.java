package com.sefinad.prueba.Controller;

import com.sefinad.prueba.Model.Tarea;
import com.sefinad.prueba.Service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {

    private final TareaService tareaService;

    public TareasController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // GET /api/tareas
    @GetMapping
    public List<Tarea> listar() {
        return tareaService.getTareas();
    }

    // POST /api/tareas
    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        if (tarea.getCompletada() == null) {
            tarea.setCompletada(false);
        }
        Tarea nueva = tareaService.createTarea(tarea);
        return ResponseEntity
                .created(URI.create("/api/tareas/" + nueva.getId()))
                .body(nueva);
    }
}
