package com.es.diecines.utils;

import com.es.diecines.dto.PeliculaCreateDTO;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.model.Pelicula;

public class Mapper {
    public static PeliculaDTO entityToDTO(Pelicula pelicula) {
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

    public static Pelicula DTOtoEntity(PeliculaCreateDTO peliculaCreateDTO) {
        Pelicula pelicula = new Pelicula();

        pelicula.setDirector(peliculaCreateDTO.getDirector());
        pelicula.setRating(peliculaCreateDTO.getRating());
        pelicula.setScreenshot(peliculaCreateDTO.getScreenshot());
        pelicula.setTime(peliculaCreateDTO.getTime());
        pelicula.setSynopsis(peliculaCreateDTO.getSynopsis());
        pelicula.setTitle(peliculaCreateDTO.getTitle());
        pelicula.setPosterImage(peliculaCreateDTO.getPosterImage());
        pelicula.setTrailer(peliculaCreateDTO.getTrailer());

        return pelicula;
    }
}
