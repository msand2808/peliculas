package com.cunori.peliculas.model;

public class Pelicula {
    private Long id;
    private String nombre;
    private String genero;
    private int anio;
    private String director;

    public Pelicula()
    {

    }

    public Pelicula(Long id, String nombre, String genero, int anio, String director){
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.anio = anio;
        this.director = director;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getGenero(){
        return genero;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }
    public int getAnio(){
        return anio;
    }


    public void setDirector(String director){
        this.director = director;
    }
    public String getDirector(){
        return director;
    }

}
