package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    public List<PeliculaDTO> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public PeliculaDTO getById(@PathVariable String id) {
        if (id == null || id.isBlank()) return null;

        PeliculaDTO pelicula = peliculaService.getById(id);

        return pelicula;
    }

    public PeliculaDTO insert() {
        return null;
    }
}
