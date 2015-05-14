package com.curso.androidm.myapplication;

import java.io.Serializable;

/**
 * Created by androidm on 12/05/2015.
 */
public class Informacion implements Serializable {
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    private String Nombre;

    public Informacion(String nombre) {
        Nombre = nombre;
    }
    public Informacion() {

    }
}
