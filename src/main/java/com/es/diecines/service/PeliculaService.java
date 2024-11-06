package com.es.diecines.service;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.model.Pelicula;
import com.es.diecines.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDTO getById(String id) {
        Long idL = 0L;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

        Pelicula pelicula = peliculaRepository.findById(idL).orElse(null);

        if (pelicula != null) {
            PeliculaDTO peliculaDTO = new PeliculaDTO();

            peliculaDTO.setDirector(pelicula.getDirector());
            peliculaDTO.setRating(pelicula.getRating());
            peliculaDTO.setScreenshot(pelicula.getScreenshot());
            peliculaDTO.setTime(pelicula.getTime());
            peliculaDTO.setSynopsis(pelicula.getSynopsis());
            peliculaDTO.setTitle(pelicula.getTitle());
            peliculaDTO.setPosterImage(pelicula.getPosterImage());
            peliculaDTO.setId(pelicula.getId());
            peliculaDTO.setTrailer(pelicula.getTrailer());

            return peliculaDTO;
        }

        return null;
    }
}
