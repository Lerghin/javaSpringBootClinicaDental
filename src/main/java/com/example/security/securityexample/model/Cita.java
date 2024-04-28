package com.example.security.securityexample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_cita;
    private LocalDate fecha_cita;
    private  int duracion;
    private String motivo;
    private String estado;
    private String observaciones;
    @ManyToOne
    @JoinColumn(name="codigo_paciente")
    private Paciente unPaciente;
    @ManyToOne
    @JoinColumn(name="codigo_doctor")
    private Doctor unDoctor;
    @ManyToOne
    @JoinColumn(name="codigo_servicio")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;
    public Cita() {
    }

    public Cita(Long codigo_cita, LocalDate fecha_cita, int duracion, String motivo, String estado, String observaciones, Paciente unPaciente, Doctor unDoctor, Servicio servicio, HistoriaClinica historiaClinica) {
        this.codigo_cita = codigo_cita;
        this.fecha_cita = fecha_cita;
        this.duracion = duracion;
        this.motivo = motivo;
        this.estado = estado;
        this.observaciones = observaciones;
        this.unPaciente = unPaciente;
        this.unDoctor = unDoctor;
        this.servicio = servicio;
        this.historiaClinica = historiaClinica;
    }
}
