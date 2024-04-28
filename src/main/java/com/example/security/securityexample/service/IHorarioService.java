package com.example.security.securityexample.service;


import com.example.security.securityexample.model.Horario;

import java.util.List;

public interface IHorarioService {
    public List<Horario> getHorarios();

    public void Savehorario(Horario horario);
    public void deleteHorario(Long codigo_horario);

    public Horario findHorario(Long horario_id);
    public void editHorario( Horario horario);
}
