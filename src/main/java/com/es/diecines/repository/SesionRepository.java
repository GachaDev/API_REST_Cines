package com.es.diecines.repository;

import com.es.diecines.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
    @Query("select s from Sesion s where s.date = CURDATE()")
    List<Sesion> getHoy();
}