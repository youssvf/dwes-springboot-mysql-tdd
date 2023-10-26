package com.cpifppiramide.manager.entrenamientos.domain;

import com.cpifppiramide.manager.ejercicios.domain.Ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entrenamiento {

    private Integer id;
    private String fecha;

    private List<Ejercicio> ejercicios;

    public Entrenamiento(Integer id, String fecha){
        this.id = id;
        this.fecha = fecha;
        this.ejercicios = new ArrayList<>();
    }

    public void addEjercicio(Ejercicio ejercicio){
        this.ejercicios.add(ejercicio);
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    @Override
    public boolean equals(Object obj) {
        Entrenamiento entrenamiento = (Entrenamiento) obj;
        return this.id.equals(entrenamiento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
