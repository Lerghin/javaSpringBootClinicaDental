package com.example.security.securityexample.service;

import com.example.security.securityexample.model.Cita;
import com.example.security.securityexample.repository.ICitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService implements  ICitaService {
    @Autowired
    private ICitaRepository citaRepo;
    @Override
    public List<Cita> getCitas() {
        List<Cita> listaCitas= citaRepo.findAll();
        return listaCitas;
    }

    @Override
    public void SaveCitas(Cita cita) {
        citaRepo.save(cita);

    }

    @Override
    public void deleteCita(Long codigo_cita) {
        citaRepo.deleteById(codigo_cita);
    }

    @Override
    public Cita findCita(Long codigo_cita) {
        Cita cita= citaRepo.findById(codigo_cita).orElse(null);
        return cita;
    }

    @Override
    public void editCita(Cita cita) {
        citaRepo.save(cita);
    }
}