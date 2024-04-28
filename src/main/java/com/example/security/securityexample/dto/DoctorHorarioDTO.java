package com.example.security.securityexample.dto;

import com.example.security.securityexample.model.Doctor;
import com.example.security.securityexample.model.Horario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorHorarioDTO {
    private Doctor doctor;
    private List<Horario> horarios;

    public DoctorHorarioDTO() {
    }

    public DoctorHorarioDTO(Doctor doctor, List<Horario> horarios) {
        this.doctor = doctor;
        this.horarios = horarios;
    }
}
