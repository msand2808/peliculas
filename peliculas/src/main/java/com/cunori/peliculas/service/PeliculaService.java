package com.cunori.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cunori.peliculas.dao.PeliculaDAO;
import com.cunori.peliculas.model.Pelicula;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaDAO peliculaDAO;

    public boolean insertar(Pelicula pelicula){
        return peliculaDAO.insertar(pelicula);
    }

    public int getCountPeliculas(){
        return peliculaDAO.getCountPeliculas();
    }

    public List<Pelicula> listPage(int size, int page){
        return peliculaDAO.listPage(size, page);
    }

    public List<Pelicula> findByName(String name){
        return peliculaDAO.findByName(name);
    }

    public boolean update(Pelicula pelicula){
        return peliculaDAO.update(pelicula);
    }

    public int eliminar(Long id){
        return peliculaDAO.eliminar(id);
    }
}
