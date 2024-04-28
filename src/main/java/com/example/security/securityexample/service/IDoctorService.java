package com.example.security.securityexample.service;

import com.example.security.securityexample.model.Doctor;

import java.util.List;

public interface IDoctorService {
    public List<Doctor> getDoctores();

    public Doctor SaveDoctor(Doctor doctor);
    public void deleteDoctor(Long codigo_doctor);

    public Doctor findDoctor(Long codigo_doctor);
    public void editDoctor( Doctor doctor);
}
