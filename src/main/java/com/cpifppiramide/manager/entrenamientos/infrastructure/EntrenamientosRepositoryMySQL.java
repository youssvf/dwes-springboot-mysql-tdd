package com.cpifppiramide.manager.entrenamientos.infrastructure;

import com.cpifppiramide.manager.context.DBConnection;
import com.cpifppiramide.manager.ejercicios.domain.Ejercicio;
import com.cpifppiramide.manager.entrenamientos.domain.Entrenamiento;
import com.cpifppiramide.manager.entrenamientos.domain.EntrenamientosRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//select en.*, ej.id as ejercicio_id, ej.titulo
//from entrenamientos en
//left join entrenamientos_ejercicios ee on ee.id_entrenamiento = en.id
//left join ejercicios ej on ej.id = ee.id_ejercicio

public class EntrenamientosRepositoryMySQL implements EntrenamientosRepository {
    @Override
    public List<Entrenamiento> getAll() {
        HashMap<Entrenamiento, List<Ejercicio>> mapaEntrenamientos = new HashMap<>();
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        try {
            String query = "select en.*, ej.id as ejercicio_id, ej.titulo " +
                    "from entrenamientos en " +
                    "left join entrenamientos_ejercicios ee on ee.entrenamiento = en.id " +
                    "left join ejercicios ej on ej.id = ee.ejercicio";
            PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Entrenamiento entrenamiento = new Entrenamiento(
                    rs.getInt("id"),
                        rs.getString("fecha")
                );
                Ejercicio ejercicio = new Ejercicio(
                    rs.getInt("ejercicio_id"),
                        rs.getString("titulo")
                );
                if(!mapaEntrenamientos.containsKey(entrenamiento)){
                    List<Ejercicio> ejercicios = new ArrayList<>(); //instancio una lista de ejercicios
                    mapaEntrenamientos.put(entrenamiento, ejercicios); //esa lista se la meto al mapa
                    entrenamiento.setEjercicios(ejercicios); //la misma dirección de memoria le va al entrenamiento
                    entrenamientos.add(entrenamiento); //añado a la lista que devolveré
                }
                mapaEntrenamientos.get(entrenamiento).add(ejercicio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entrenamientos;
    }

    @Override
    public Entrenamiento getEntrenamiento(Integer id) {
        Entrenamiento entrenamiento = null;
        try{
            String queryEntrenamiento = "" +
                    "select * " +
                    "from entrenamientos " +
                    "where id = ?";
            PreparedStatement preparedStatementEntrenamiento = DBConnection.getInstance().prepareStatement(queryEntrenamiento);
            preparedStatementEntrenamiento.setInt(1, id);
            ResultSet rsEntrenamiento = preparedStatementEntrenamiento.executeQuery();
            while (rsEntrenamiento.next()){
                entrenamiento = new Entrenamiento(rsEntrenamiento.getInt("id"), rsEntrenamiento.getString("fecha"));
                entrenamiento.setEjercicios(new ArrayList<>());
            }
            if(entrenamiento != null) {
                String queryEjercicios = "" +
                        "select * " +
                        "from ejercicios " +
                        "where id in ( " +
                        "select ejercicio " +
                        "from entrenamientos_ejercicios " +
                        "where entrenamiento = ?" +
                        ")";
                PreparedStatement preparedStatementEjercicios = DBConnection.getInstance().prepareStatement(queryEjercicios);
                preparedStatementEjercicios.setInt(1, id);
                ResultSet rsEjercicios = preparedStatementEjercicios.executeQuery();
                while(rsEjercicios.next()){
                    Ejercicio ejercicio = new Ejercicio(
                            rsEjercicios.getInt("id"),
                            rsEjercicios.getString("titulo")
                    );
                    entrenamiento.addEjercicio(ejercicio);
                }
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return entrenamiento;
    }
}
