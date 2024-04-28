package com.example.security.securityexample.service;


import com.example.security.securityexample.model.Servicio;
import com.example.security.securityexample.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService implements IServicioService{
    @Autowired
    private IServicioRepository serviRepo;
    @Override
    public List<Servicio> getServicios() {
        List<Servicio> listaServicios= serviRepo.findAll();
        return listaServicios;
    }

    @Override
    public void SaveServicios(Servicio servicio) {
        serviRepo.save(servicio);
    }

    @Override
    public void deleteServicio(Long codigo_servicio) {
        serviRepo.deleteById(codigo_servicio);
    }

    @Override
    public Servicio findServicio(Long codigo_servicio) {
        Servicio servicio= serviRepo.findById(codigo_servicio).orElse(null);
        return servicio;
    }

    @Override
    public void editServicio(Servicio servicio) {
        serviRepo.save(servicio);
    }
}
