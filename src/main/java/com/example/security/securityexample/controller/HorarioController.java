package com.example.security.securityexample.controller;

import com.example.security.securityexample.model.Horario;
import com.example.security.securityexample.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HorarioController {
    @Autowired
    private IHorarioService horaServ;
    @GetMapping("/horarios/traer")
    public List<Horario> getHorarios(){
        return horaServ.getHorarios();
    }
    @GetMapping("/horarios/traer/{horario_id}")
    public Horario findHorario(@PathVariable Long horario_id){

        return  horaServ.findHorario(horario_id);
    }

    @PostMapping("/horarios/crear")
    public String createHorario(@RequestBody Horario horario){
        horaServ.Savehorario(horario);
        return "El  horario se ha creado correctamente";
    }

    @DeleteMapping("/horarios/borrar/{horario_id}")
    public String deleteDoctor(@PathVariable Long horario_id){
        horaServ.deleteHorario(horario_id);
        return "fue borrada el Horario";


    }

    @PutMapping("/horarios/editar")
    public String editHorario(@RequestBody Horario horario){
        horaServ.editHorario(horario);
        return "se ha editado correctamente";
    }
}
