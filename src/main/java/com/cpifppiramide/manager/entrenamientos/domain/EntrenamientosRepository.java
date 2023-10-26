package com.cpifppiramide.manager.entrenamientos.domain;

import java.util.List;

public interface EntrenamientosRepository {

    public List<Entrenamiento> getAll();
    public Entrenamiento getEntrenamiento(Integer id);

}
