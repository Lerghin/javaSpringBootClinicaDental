package com.example.security.securityexample.service;


import com.example.security.securityexample.model.Horario;
import com.example.security.securityexample.repository.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService implements IHorarioService {
    @Autowired
    private IHorarioRepository horaRepo;
    @Override
    public List<Horario> getHorarios() {
        List<Horario> listaHorarios= horaRepo.findAll();
        return listaHorarios;
    }

    @Override
    public void Savehorario(Horario horario) {
        horaRepo.save(horario);
    }

    @Override
    public void deleteHorario(Long horario_id) {
        horaRepo.deleteById(horario_id);
    }

    @Override
    public Horario findHorario(Long horario_id) {
        Horario horario= horaRepo.findById(horario_id).orElse(null);
        return horario;
    }

    @Override
    public void editHorario(Horario horario) {
        horaRepo.save(horario);
    }
}
