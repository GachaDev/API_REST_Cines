package com.es.diecines.service;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.dto.SesionCreateDTO;
import com.es.diecines.dto.SesionDTO;
import com.es.diecines.model.Sesion;
import com.es.diecines.repository.SesionRepository;
import com.es.diecines.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SesionService {
    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private PeliculaService peliculaService;

    public List<SesionDTO> getAll() {
        List<Sesion> sesiones = sesionRepository.findAll();
        List<SesionDTO> sesionesDTOS = new ArrayList<>();

        sesiones.forEach(sesion -> {
            SesionDTO sesionDTO = Mapper.entityToDTO(sesion);

            sesionesDTOS.add(sesionDTO);
        });

        return sesionesDTOS;
    }

    public SesionDTO getById(String id) {
        Long idL = 0L;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

        Sesion sesion = sesionRepository.findById(idL).orElse(null);

        if (sesion != null) {
            SesionDTO sesionDTO = Mapper.entityToDTO(sesion);

            return sesionDTO;
        }

        return null;
    }

    public List<SesionDTO> getHoy() {
        List<Sesion> sesiones = sesionRepository.getHoy();
        List<SesionDTO> sesionesDTOS = new ArrayList<>();

        sesiones.forEach(sesion -> {
            SesionDTO sesionDTO = Mapper.entityToDTO(sesion);

            sesionesDTOS.add(sesionDTO);
        });

        return sesionesDTOS;
    }

    public SesionDTO insert(SesionCreateDTO sesionCreateDTO) {
        PeliculaDTO peliculaDTO = peliculaService.getById(sesionCreateDTO.getMovieId().toString());

        if (peliculaDTO == null) {
            return null;
        }

        Sesion sesion = Mapper.DtoToEntity(sesionCreateDTO, Mapper.DTOtoEntity(peliculaDTO));

        sesionRepository.save(sesion);

        SesionDTO sesionDTO = Mapper.entityToDTO(sesion);

        return sesionDTO;
    }

    public boolean delete(String id) {
        Long idL = 0L;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        sesionRepository.deleteById(idL);

        return true;
    }
}
