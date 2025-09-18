package com.sefinad.prueba.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sefinad.prueba.Model.Tarea;
import com.sefinad.prueba.Repository.TareasRepository;

import java.util.List;


@Service
public class TareaService {

    private final TareasRepository tareasRepository;

    @Autowired
    public TareaService(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }

    public List<Tarea> getTareas() {
        return tareasRepository.findAll();
    }

    public Tarea createTarea(Tarea tarea) {
        return tareasRepository.save(tarea);
    }
}

