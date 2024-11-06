package com.es.diecines.service;

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
}
