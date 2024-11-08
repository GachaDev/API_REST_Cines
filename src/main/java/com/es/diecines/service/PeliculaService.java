package com.es.diecines.service;

import com.es.diecines.dto.PeliculaCreateDTO;
import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.error.BaseDeDatosException;
import com.es.diecines.model.Pelicula;
import com.es.diecines.repository.PeliculaRepository;
import com.es.diecines.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<PeliculaDTO> getAll() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        List<PeliculaDTO> peliculasDTOS = new ArrayList<>();

        peliculas.forEach(pelicula -> {
            PeliculaDTO peliculaDTO = Mapper.entityToDTO(pelicula);

            peliculasDTOS.add(peliculaDTO);
        });

        return peliculasDTOS;
    }

    public PeliculaDTO getById(String id) {
        Long idL = 0L;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException("La id debe de ser un número correcto");
        }

        Pelicula pelicula = null;

        try {
            pelicula = peliculaRepository.findById(idL).orElse(null);
        } catch (Exception e) {
            throw new BaseDeDatosException(idL + " id erroneo");
        }

        if (pelicula != null) {
            PeliculaDTO peliculaDTO = Mapper.entityToDTO(pelicula);

            return peliculaDTO;
        }

        return null;
    }

    public List<PeliculaDTO> getByMinRating(String rating) {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        Double ratingD = 0D;

        try {
            ratingD = Double.parseDouble(rating);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return peliculaDTOS;
        }

        List<Pelicula> peliculas = peliculaRepository.getByMinRating(ratingD);

        peliculas.forEach(pelicula -> {
            PeliculaDTO peliculaDTO = Mapper.entityToDTO(pelicula);

            peliculaDTOS.add(peliculaDTO);
        });

        return peliculaDTOS;
    }

    public PeliculaDTO insert(PeliculaCreateDTO peliculaCreateDTO) {
        Pelicula pelicula = Mapper.DTOtoEntity(peliculaCreateDTO);

        peliculaRepository.save(pelicula);

        PeliculaDTO peliculaDTO = Mapper.entityToDTO(pelicula);

        return peliculaDTO;
    }

    public PeliculaDTO update(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = Mapper.DTOtoEntity(peliculaDTO);
        PeliculaDTO exist = getById(peliculaDTO.getId().toString());

        if (exist == null) {
            return null;
        }

        peliculaRepository.save(pelicula);

        PeliculaDTO updatedPeliculaDTO = Mapper.entityToDTO(pelicula);

        return updatedPeliculaDTO;
    }

    public boolean delete(String id) {
        Long idL = 0L;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException("La id debe de ser un número correcto");
        }

        try {
            PeliculaDTO exist = getById(id);

            if (exist == null) return false;
        } catch (BaseDeDatosException e) {
            throw new BaseDeDatosException(idL + " id erroneo");
        }

        peliculaRepository.deleteById(idL);

        return true;
    }
}
