package com.cpifppiramide.manager;

import com.cpifppiramide.manager.ejercicios.domain.Ejercicio;
import com.cpifppiramide.manager.entrenamientos.application.EntrenamientosUseCases;
import com.cpifppiramide.manager.entrenamientos.domain.Entrenamiento;
import com.cpifppiramide.manager.entrenamientos.infrastructure.EntrenamientosRepositoryMySQL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntrenamientosUseCasesTest {

    private EntrenamientosUseCases entrenamientosUseCases;

    public EntrenamientosUseCasesTest(){
        this.entrenamientosUseCases = new EntrenamientosUseCases(
                new EntrenamientosRepositoryMySQL()
        );
    }

    @Test
    public void getAll(){
        List<Entrenamiento> entrenamientos = this.entrenamientosUseCases.getAll();
        assertEquals(3,entrenamientos.size());
    }

    @Test
    public void getEntrenamiento(){
        Entrenamiento entrenamiento = this.entrenamientosUseCases.getEntrenamiento(1);
        assertEquals(1,entrenamiento.getId());
        assertEquals("2023-10-25", entrenamiento.getFecha());
        Ejercicio ejercicio1 = entrenamiento.getEjercicios().get(0);
        assertEquals(1,ejercicio1.getId());
        assertEquals("Flexiones", ejercicio1.getTitulo());
    }

}
