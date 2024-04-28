package com.example.security.securityexample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_doctor;
    private String nombre;
    private String apellido;
    private int cedula;
    private String telefono;
    private String especialidad;
    private String correoElectronico;

    @OneToMany(mappedBy = "doctor")
    private List<Horario> horarios;
    @OneToMany(mappedBy = "unDoctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> pacientes;
    public Doctor() {
    }

    public Doctor(Long codigo_doctor, String nombre, String apellido, int cedula, String telefono, String especialidad, String correoElectronico, List<Horario> horarios, List<Paciente> pacientes) {
        this.codigo_doctor = codigo_doctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.correoElectronico = correoElectronico;
        this.horarios = horarios;
        this.pacientes = pacientes;
    }
}
