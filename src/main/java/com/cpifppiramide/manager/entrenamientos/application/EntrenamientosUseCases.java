package com.cpifppiramide.manager.entrenamientos.application;

import com.cpifppiramide.manager.entrenamientos.domain.Entrenamiento;
import com.cpifppiramide.manager.entrenamientos.domain.EntrenamientosRepository;

import java.util.List;

public class EntrenamientosUseCases {

    private EntrenamientosRepository entrenamientosRepository;

    public EntrenamientosUseCases(EntrenamientosRepository entrenamientosRepository){
        this.entrenamientosRepository = entrenamientosRepository;
    }

    public List<Entrenamiento> getAll(){
        return this.entrenamientosRepository.getAll();
    }

    public Entrenamiento getEntrenamiento(Integer id){
        return this.entrenamientosRepository.getEntrenamiento(id);
    }


}
