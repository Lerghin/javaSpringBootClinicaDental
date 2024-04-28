package com.example.security.securityexample.service;

import com.example.security.securityexample.model.Paciente;

import java.util.List;

public  interface IPacienteService {
    public List<Paciente> getPacientes();

    public void deletePaciente(Long codigo_paciente);

    public Paciente savePaciente(Paciente paciente);
    public Paciente findPaciente(Long codigo_paciente);
    public void editPaciente( Paciente paciente);
}
