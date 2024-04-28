package com.example.security.securityexample.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDoctorDTO {

    private Long codigo_paciente;
    private String nombre;
    private String apellido;
    private String sexo;
    private int cedula;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Long codigo_doctor;
    private String nombreDoctor;
    private String apellidoDoctor;
    private int cedulaDoctor;


    public PacienteDoctorDTO() {
    }

    public PacienteDoctorDTO(Long codigo_paciente, String nombre, String apellido, String sexo, int cedula, String direccion, String telefono, String correoElectronico, Long codigo_doctor, String nombreDoctor, String apellidoDoctor, int cedulaDoctor) {
        this.codigo_paciente = codigo_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.codigo_doctor = codigo_doctor;
        this.nombreDoctor = nombreDoctor;
        this.apellidoDoctor = apellidoDoctor;
        this.cedulaDoctor = cedulaDoctor;
    }
}
