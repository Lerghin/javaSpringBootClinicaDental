package com.example.security.securityexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_paciente;
    private String nombre;
    private String apellido;
    private String sexo;
    private int cedula;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    @ManyToOne
    @JoinColumn (name="codigo_doctor")
    @JsonIgnore
    private Doctor unDoctor;
    public Paciente() {
    }



    public Paciente(Long codigo_paciente, String nombre, String apellido, int cedula, String direccion, String telefono, String correoElectronico, String sexo) {
        this.codigo_paciente = codigo_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }
}
