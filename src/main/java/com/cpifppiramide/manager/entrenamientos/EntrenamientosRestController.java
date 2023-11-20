package com.cpifppiramide.manager.entrenamientos;

import com.cpifppiramide.manager.entrenamientos.application.EntrenamientosUseCases;
import com.cpifppiramide.manager.entrenamientos.domain.Entrenamiento;
import com.cpifppiramide.manager.entrenamientos.domain.EntrenamientosRepository;
import com.cpifppiramide.manager.entrenamientos.infrastructure.EntrenamientosRepositoryMySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenamientosRestController {
    private EntrenamientosUseCases entrenamientosUseCases;

    public EntrenamientosRestController(){
        this.entrenamientosUseCases = new EntrenamientosUseCases(new EntrenamientosRepositoryMySQL());
    }

    @GetMapping("/entrenamientos")
    public List<Entrenamiento> entrenamientos(){
        return this.entrenamientosUseCases.getAll();
    }

    @GetMapping("/entrenamientos/{id}")
    public Entrenamiento getEntrenamiento(@PathVariable Integer id){
        return  this.entrenamientosUseCases.getEntrenamiento(id);
    }
}
