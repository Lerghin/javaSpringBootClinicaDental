package com.example.security.securityexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Horario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long horario_id;
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    private String diaSemana;
    private String horaInicio;
    private String horaFin;

    public Horario() {
    }

    public Horario(Long horario_id, Doctor doctor, String diaSemana, String horaInicio, String horaFin) {
        this.horario_id = horario_id;
        this.doctor = doctor;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}
