package com.example.security.securityexample.service;

import com.example.security.securityexample.model.*;
import com.example.security.securityexample.repository.IDoctorRepository;
import com.example.security.securityexample.repository.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    private IDoctorRepository doctorRepo;
    @Autowired
    private IHorarioRepository horaRepo;
    @Override
    public List<Doctor> getDoctores() {
        List<Doctor> listaDoctores= doctorRepo.findAll();
        return listaDoctores;
    }



    @Override
    public Doctor SaveDoctor(Doctor doctor) {
        Doctor savedDoctor= doctorRepo.save(doctor);
        for(Horario horario: doctor.getHorarios()){
            horaRepo.save(horario);
        }
        return savedDoctor;
    }

    @Override
    public void deleteDoctor(Long codigo_doctor) {
        doctorRepo.deleteById(codigo_doctor);
    }

    @Override
    public Doctor findDoctor(Long codigo_doctor) {
        Doctor doctor= doctorRepo.findById(codigo_doctor).orElse(null);
        return doctor;
    }

    @Override
    public void editDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }
}
