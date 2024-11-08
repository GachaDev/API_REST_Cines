package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaCreateDTO;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.error.BaseDeDatosException;
import com.es.diecines.error.ErrorGenerico;
import com.es.diecines.service.PeliculaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getById(@PathVariable String id, HttpServletRequest request) {
        try {
            if (id == null || id.isBlank()) return new ResponseEntity<ErrorGenerico>(new ErrorGenerico("La id no puede estar vacia", request.getRequestURI()), HttpStatus.BAD_REQUEST);

            PeliculaDTO pelicula = peliculaService.getById(id);

            if (pelicula == null) {
                return new ResponseEntity<ErrorGenerico>(new ErrorGenerico("Película no encontrada", request.getRequestURI()), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<PeliculaDTO>(pelicula, HttpStatus.OK);
        } catch (NumberFormatException e) {
            ErrorGenerico error = new ErrorGenerico(e.getMessage(), request.getRequestURI());

            return new ResponseEntity<ErrorGenerico>(error, HttpStatus.BAD_REQUEST);
        } catch (BaseDeDatosException e) {
            ErrorGenerico error = new ErrorGenerico(e.getMessage(), request.getRequestURI());

            return new ResponseEntity<ErrorGenerico>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PutMapping("/")
    public PeliculaDTO update(@RequestBody PeliculaDTO peliculaDTO) {
        PeliculaDTO updatedPeliculaDTO = peliculaService.update(peliculaDTO);

        return updatedPeliculaDTO;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        if (id == null || id.isBlank()) return false;

        boolean deleted = peliculaService.delete(id);

        return deleted;
    }
}
