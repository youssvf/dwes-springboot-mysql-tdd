package com.cpifppiramide.manager.ejercicios.domain;

public class Ejercicio {

    private Integer id;
    private String titulo;

    public Ejercicio(Integer id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }


    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
