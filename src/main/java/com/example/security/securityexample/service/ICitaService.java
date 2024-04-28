package com.example.security.securityexample.service;

import com.example.security.securityexample.model.Cita;

import java.util.List;

public interface ICitaService {
    public List<Cita> getCitas();

    public void SaveCitas(Cita cita);
    public void deleteCita(Long codigo_cita);

    public Cita findCita(Long codigo_cita);
    public void editCita( Cita cita);

}