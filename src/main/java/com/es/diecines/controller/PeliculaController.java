package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaCreateDTO;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/")
    public List<PeliculaDTO> getAll() {
        return peliculaService.getAll();
    }

    @GetMapping("/{id}")
    public PeliculaDTO getById(@PathVariable String id) {
        if (id == null || id.isBlank()) return null;

        PeliculaDTO pelicula = peliculaService.getById(id);

        return pelicula;
    }

    @GetMapping("/rating/{minRating}")
    public List<PeliculaDTO> getByMinRating(@PathVariable String minRating) {
        if (minRating == null || minRating.isBlank()) return null;

        List<PeliculaDTO> peliculas = peliculaService.getByMinRating(minRating);

        return peliculas;
    }

    @PostMapping("/")
    public PeliculaDTO insert(@RequestBody PeliculaCreateDTO peliculaCreateDTO) {
        if (peliculaCreateDTO == null) {
            return null;
        }

        PeliculaDTO peliculaDTO = peliculaService.insert(peliculaCreateDTO);

        return peliculaDTO;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        if (id == null || id.isBlank()) return false;

        boolean deleted = peliculaService.delete(id);

        return deleted;
    }
}
