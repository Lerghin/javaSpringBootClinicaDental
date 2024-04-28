package com.example.security.securityexample.controller;


import com.example.security.securityexample.model.Cita;
import com.example.security.securityexample.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CitaController {

    @Autowired
     ICitaService citaService;
    @GetMapping("/citas/traer")
    public List<Cita> getCitas(){
        return citaService.getCitas();

    }
    @GetMapping("/citas/traer/{codigo_cita}")
    public Cita findCita(@PathVariable Long codigo_cita){

        return  citaService.findCita(codigo_cita);
    }

    @PostMapping("/citas/crear")
    public String createCita(@RequestBody Cita cita){
        citaService.SaveCitas(cita);
        return "La Cita se ha creado correctamente";
    }

    @DeleteMapping("/citas/borrar/{codigo_cita}")
    public String deleteCita(@PathVariable Long codigo_cita){
        citaService.deleteCita(codigo_cita);
        return "fue borrada la cita";


    }

    @PutMapping("/citas/editar")
    public String editCita(@RequestBody Cita cita){
        citaService.editCita(cita);
        return "se ha editado correctamente";
    }


}
