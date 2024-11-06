package com.es.diecines.utils;

import com.es.diecines.dto.PeliculaCreateDTO;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.dto.SesionDTO;
import com.es.diecines.model.Pelicula;
import com.es.diecines.model.Sesion;

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

    public static SesionDTO entityToDTO(Sesion s) {
        SesionDTO sDto = new SesionDTO();

        sDto.setId(s.getId());
        sDto.setMovieId(s.getPelicula().getId());
        sDto.setRoomId(s.getRoomId());
        sDto.setDate(s.getDate());

        return sDto;
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

    public static Pelicula DTOtoEntity(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = new Pelicula();

        pelicula.setDirector(peliculaDTO.getDirector());
        pelicula.setRating(peliculaDTO.getRating());
        pelicula.setScreenshot(peliculaDTO.getScreenshot());
        pelicula.setTime(peliculaDTO.getTime());
        pelicula.setSynopsis(peliculaDTO.getSynopsis());
        pelicula.setTitle(peliculaDTO.getTitle());
        pelicula.setPosterImage(peliculaDTO.getPosterImage());
        pelicula.setTrailer(peliculaDTO.getTrailer());
        pelicula.setId(peliculaDTO.getId());

        return pelicula;
    }

    public static Sesion DtoToEntity(SesionDTO sDto, Pelicula p) {
        Sesion s = new Sesion();

        s.setId(sDto.getId());
        s.setPelicula(p);
        s.setRoomId(sDto.getRoomId());
        s.setDate(sDto.getDate());

        return s;
    }
}
