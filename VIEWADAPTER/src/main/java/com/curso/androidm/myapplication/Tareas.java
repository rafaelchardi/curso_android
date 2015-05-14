package com.curso.androidm.myapplication;

/**
 * Created by androidm on 13/05/2015.
 */
public class Tareas {
    private String nombre;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tareas(String nombre, String descripcion) {

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Tareas() {

    }
}
