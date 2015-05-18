package com.curso.androidm.terremotos;

import java.io.Serializable;

/**
 * Created by androidm on 18/05/2015.
 */
public class Terremoto implements Serializable{


    public Terremoto() {
            }
    public Terremoto(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    private String Descripcion;

    public String toString(){

        return  getDescripcion();
    }
}
