package com.example.security.securityexample.service;


import com.example.security.securityexample.model.HistoriaClinica;
import com.example.security.securityexample.repository.IHistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoriaClinicaService implements IHistoriaService{
    @Autowired
    private IHistoriaClinicaRepository histoRepo;
    @Override
    public List<HistoriaClinica> gethistorias() {
        List<HistoriaClinica> listaHistorias= histoRepo.findAll();
        return listaHistorias;
    }

    @Override
    public void SaveHistoria(HistoriaClinica historia) {
        histoRepo.save(historia);
    }

    @Override
    public void deleteHistoria(Long codigo_historia) {
        histoRepo.deleteById(codigo_historia);
    }

    @Override
    public HistoriaClinica findHistoria(Long codigo_historia) {
        HistoriaClinica historiaClinica= histoRepo.findById(codigo_historia).orElse(null);
        return historiaClinica;
    }

    @Override
    public void editHistoria(HistoriaClinica historia) {
        histoRepo.save(historia);

    }
}
