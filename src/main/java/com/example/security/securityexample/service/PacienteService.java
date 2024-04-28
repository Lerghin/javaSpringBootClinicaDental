package com.example.security.securityexample.service;


import com.example.security.securityexample.model.Paciente;
import com.example.security.securityexample.repository.IDoctorRepository;
import com.example.security.securityexample.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    private IPacienteRepository pacienteRepo;
    @Autowired
    private IDoctorRepository docRepo;
    @Override
    public List<Paciente> getPacientes() {
        List<Paciente> ListaPacientes= pacienteRepo.findAll();

        return ListaPacientes;
    }




    @Override
    public void deletePaciente(Long codigo_paciente) {
        pacienteRepo.deleteById(codigo_paciente);
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {

        return pacienteRepo.save(paciente);
    }

    @Override
    public Paciente findPaciente(Long codigo_paciente) {
        Paciente paciente = pacienteRepo.findById(codigo_paciente).orElse(null);
        return paciente;
    }

    @Override
    public void editPaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }
}
