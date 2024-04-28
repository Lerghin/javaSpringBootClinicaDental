package com.example.security.securityexample.service;


import com.example.security.securityexample.model.Servicio;

import java.util.List;

public interface IServicioService {
    public List<Servicio> getServicios();

    public void SaveServicios(Servicio servicio);
    public void deleteServicio(Long codigo_servicio);

    public Servicio findServicio(Long codigo_servicio);
    public void editServicio( Servicio servicio);



}
