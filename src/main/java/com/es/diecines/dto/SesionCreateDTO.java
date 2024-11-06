package com.es.diecines.dto;

import java.time.LocalDate;

public class SesionCreateDTO {
    private Long movieId;
    private Long roomId;
    private LocalDate date;

    public SesionCreateDTO(){}
    public SesionCreateDTO(Long movieId, Long roomId, LocalDate date) {
        this.movieId = movieId;
        this.roomId = roomId;
        this.date = date;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
