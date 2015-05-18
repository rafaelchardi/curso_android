package com.curso.androidm.terremotos;

import java.io.Serializable;

/**
 * Created by androidm on 18/05/2015.
 */
public class TipoTerremoto implements Serializable{
    public TipoTerremoto() {
    }
    public TipoTerremoto(int intensidad, String descripcion) {
        Intensidad = intensidad;
        Descripcion = descripcion;
    }

    public int getIntensidad() {
        return Intensidad;
    }

    public void setIntensidad(int intensidad) {
        Intensidad = intensidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    private int Intensidad;
    private String Descripcion;

    public String toString(){

        return  Integer.toString(getIntensidad()) + ' ' + getDescripcion();
    }

}
