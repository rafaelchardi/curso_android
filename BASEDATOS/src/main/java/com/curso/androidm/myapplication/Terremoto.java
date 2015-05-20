package com.curso.androidm.myapplication;

import java.util.Date;

/**
 * Created by androidm on 20/05/2015.
 */
public class Terremoto {
    private String id;
    private String titulo;
    private Date fecha;
    private String link;
    private Double latitud;
    private Double longitud;
    private Float magnitud;



    @Override
    public String toString() {
        return "Terremoto{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terremoto terremoto = (Terremoto) o;

        return id.equals(terremoto.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Terremoto() {
    }

    public Terremoto(String id, String titulo, Date fecha, String link, Double latitud, Double longitud, Float magnitud) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.link = link;
        this.latitud = latitud;
        this.longitud = longitud;
        this.magnitud = magnitud;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(Float magnitud) {
        this.magnitud = magnitud;
    }



}
