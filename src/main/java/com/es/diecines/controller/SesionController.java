package com.es.diecines.controller;

import com.es.diecines.dto.SesionCreateDTO;
import com.es.diecines.dto.SesionDTO;
import com.es.diecines.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesiones")
public class SesionController {
    @Autowired
    private SesionService sesionService;

    @GetMapping("/")
    public List<SesionDTO> getAll() {
        return sesionService.getAll();
    }

    @GetMapping("/hoy")
    public List<SesionDTO> getHoy() {
        return sesionService.getHoy();
    }

    @GetMapping("/{id}")
    public SesionDTO getById(@PathVariable String id) {
        if (id == null || id.isBlank()) return null;

        SesionDTO sesionDTO = sesionService.getById(id);

        return sesionDTO;
    }

    @PostMapping("/")
    public SesionDTO insert(@RequestBody SesionCreateDTO sesionCreateDTO) {
        if (sesionCreateDTO == null) {
            return null;
        }

        SesionDTO sesionDTO = sesionService.insert(sesionCreateDTO);

        return sesionDTO;
    }
}
