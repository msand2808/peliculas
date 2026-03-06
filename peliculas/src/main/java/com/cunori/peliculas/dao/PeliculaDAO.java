package com.cunori.peliculas.dao;
import com.cunori.peliculas.model.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * PeliculaDAO, operaciones CRUD
 */
@Repository
public class PeliculaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final RowMapper<Pelicula> RowMapper = new RowMapper<Pelicula>() {
        @Override
        public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pelicula pelicula = new Pelicula();
            pelicula.setId(rs.getLong("id"));
            pelicula.setNombre(rs.getString("nombre"));
            pelicula.setGenero(rs.getString("genero"));
            pelicula.setDirector(rs.getString("director"));
            pelicula.setAnio(rs.getInt("anio"));
            return pelicula;
        }      
    };

    /**
     * Funcion de insercion de peliculas
     * 
     */
    public boolean insertar(Pelicula pelicula){
        String sql = "insert into Peliculas(nombre, genero, anio, director) values (?, ?, ?, ?)";
        int filasAfectadas = jdbcTemplate.update(
            sql,
            pelicula.getNombre(),
            pelicula.getGenero(),
            pelicula.getAnio(),
            pelicula.getDirector() 
        );

        return filasAfectadas > 0;
    }

    /**
     * Funcion de conteo de Peliculas
     */
    public int getCountPeliculas(){
        String sql = "select count(*) from Peliculas";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count !=null ? count : 0;
    }


    /**
     * Funcion de Listar Peliculas para paginacion
     */
    public List<Pelicula> listPage(int size, int page){
        String sql = "select * from Peliculas limit ? offset ?";
        int offset = page * size;
        return jdbcTemplate.query(sql,RowMapper,  size, offset);
    }

    /**
     * Funcion de Busqueda por nombre
     */

    public List<Pelicula> findByName(String name){
        String sql = "select * from Peliculas where nombre like ?";
        return jdbcTemplate.query(sql, RowMapper, "%"+name+"%");
    }

    /**
     * Actualizacion de Pelicula
     */
    public boolean update(Pelicula pelicula){
        String sql = "update Peliculas set nombre=?, genero = ?, anio =?, director=? where id=?";
        int filasAfectadas = jdbcTemplate.update(sql,
            pelicula.getNombre(),
            pelicula.getGenero(),
            pelicula.getAnio(),
            pelicula.getDirector(),
            pelicula.getId()
        );

        return filasAfectadas > 0;
    }

    public int eliminar(Long id){
        String sql = "delete from Peliculas where id=?";
        return jdbcTemplate.update(sql, id);
    }

}
