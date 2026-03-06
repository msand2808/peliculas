package com.cunori.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cunori.peliculas.model.Pelicula;
import com.cunori.peliculas.service.PeliculaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaservice;

    @GetMapping
    public List<Pelicula> listar(@RequestParam int page, @RequestParam int size){
        return peliculaservice.listPage(size, page);
    }
    
    @GetMapping("/count")
    public int getCountPeliculas(){
        return peliculaservice.getCountPeliculas();
    }

    @GetMapping("/buscar")
    public List<Pelicula> findByName(@RequestParam String nombre){
        return peliculaservice.findByName(nombre);
    }

    @PostMapping
    public ResponseEntity<?> insertar( @RequestBody Pelicula pelicula){
            boolean creado = peliculaservice.insertar(pelicula);

            if(creado){
                return ResponseEntity.status(201).build();
            }else{
                return ResponseEntity.status(400).build();
            }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Pelicula pelicula, @PathVariable Long id){
        pelicula.setId(id);
        boolean actualizado = peliculaservice.update(pelicula);

        if(actualizado){
            return ResponseEntity.status(200).build();
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){

        int borrado = peliculaservice.eliminar(id);

        if (borrado == 1) {
           return ResponseEntity.status(204).build();
        }else{
           return ResponseEntity.status(404).build();
        }

    }
    

}
