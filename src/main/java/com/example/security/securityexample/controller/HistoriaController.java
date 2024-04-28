package com.example.security.securityexample.controller;



import com.example.security.securityexample.model.HistoriaClinica;
import com.example.security.securityexample.service.IHistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoriaController {
    @Autowired
    private IHistoriaService histoServ;

    @GetMapping("/historias/traer")
    public List<HistoriaClinica> getHistorias(){
        return histoServ.gethistorias();

    }
    @GetMapping("/historias/traer/{codigo_historia}")
    public HistoriaClinica findHistoria(@PathVariable Long codigo_historia){

        return  histoServ.findHistoria(codigo_historia);
    }

    @PostMapping("/historias/crear")
    public String createHistoria(@RequestBody HistoriaClinica historia){
        histoServ.SaveHistoria(historia);
        return "La historia se ha creado correctamente";
    }

    @DeleteMapping("/historias/borrar/{codigo_historia}")
    public String deleteHistoria(@PathVariable Long codigo_historia){
        histoServ.deleteHistoria(codigo_historia);
        return "fue borrada la historia";


    }

    @PutMapping("/historias/editar")
    public String editHistoria(@RequestBody HistoriaClinica historia){
        histoServ.editHistoria(historia);
        return "se ha editado correctamente";
    }
}
