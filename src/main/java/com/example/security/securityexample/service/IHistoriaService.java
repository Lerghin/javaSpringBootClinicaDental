package com.example.security.securityexample.service;


import com.example.security.securityexample.model.HistoriaClinica;

import java.util.List;

public interface IHistoriaService {
    public List<HistoriaClinica> gethistorias();

    public void SaveHistoria(HistoriaClinica historia);
    public void deleteHistoria(Long codigo_historia);

    public HistoriaClinica findHistoria(Long codigo_historia);
    public void editHistoria( HistoriaClinica historia);
}
