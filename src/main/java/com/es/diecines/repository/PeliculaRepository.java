package com.es.diecines.repository;

import com.es.diecines.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
    @Query("select p from Pelicula p where p.rating >= ?1")
    List<Pelicula> getByMinRating(Double rating);
}