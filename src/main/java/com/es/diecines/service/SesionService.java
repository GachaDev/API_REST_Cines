package com.es.diecines.service;

import com.es.diecines.dto.SesionDTO;
import com.es.diecines.model.Sesion;
import com.es.diecines.repository.SesionRepository;
import com.es.diecines.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionService {
    @Autowired
    private SesionRepository sesionRepository;

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
