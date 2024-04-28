package com.example.security.securityexample.controller;



import com.example.security.securityexample.model.Servicio;
import com.example.security.securityexample.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicioController {
    @Autowired
    IServicioService serviService;

    @GetMapping("/servicios/traer")
    public List<Servicio> getServicio(){
        return serviService.getServicios();
    }
    @GetMapping("/servicios/traer/{codigo_servicio}")
    public Servicio findServicio(@PathVariable Long codigo_servicio){

        return  serviService.findServicio(codigo_servicio);
    }

    @PostMapping("/servicios/crear")
    public String createService(@RequestBody Servicio servicio){
        serviService.SaveServicios(servicio);
        return "El  servicio se ha creado correctamente";
    }

    @DeleteMapping("/servicios/borrar/{codigo_servicio}")
    public String deleteServicio(@PathVariable Long codigo_servicio){
        serviService.deleteServicio(codigo_servicio);
        return "fue borrado el servicio";


    }

    @PutMapping("/servicios/editar")
    public String editServicio(@RequestBody Servicio servicio){
        serviService.editServicio(servicio);
        return "se ha editado correctamente";
    }
}
