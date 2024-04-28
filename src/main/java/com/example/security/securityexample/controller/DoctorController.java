package com.example.security.securityexample.controller;


import com.example.security.securityexample.model.Doctor;
import com.example.security.securityexample.model.Horario;
import com.example.security.securityexample.service.IDoctorService;
import com.example.security.securityexample.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    IDoctorService docServ;
    @Autowired
    IHorarioService horaServ;
    @GetMapping("/doctor/traer")
    public List<Doctor> getDoctores(){
        return docServ.getDoctores();

    }
    @GetMapping("/doctor/traer/{codigo_doctor}")
    public Doctor findDoctor(@PathVariable Long codigo_doctor){

        return  docServ.findDoctor(codigo_doctor);
    }
    @PostMapping("/doctor/crear")
    public ResponseEntity<?> crearDoctor(@RequestBody Doctor doctor) {
        try {

            // Asigna el doctor al horario
            for (Horario horario : doctor.getHorarios()) {
                Horario unHorario = horaServ.findHorario(horario.getHorario_id());


                if (unHorario.getDoctor() != null) {

                    return new ResponseEntity<>("El horario " + unHorario.getDiaSemana() + " " + unHorario.getHoraInicio() + "-" + unHorario.getHoraFin() + " ya está ocupado", HttpStatus.BAD_REQUEST);
                }

                // Asigna el doctor al horario
                horario.setHorario_id(unHorario.getHorario_id());
                horario.setDiaSemana(unHorario.getDiaSemana());
                horario.setHoraFin(unHorario.getHoraFin());
                horario.setHoraInicio(unHorario.getHoraInicio());
                horario.setDoctor(doctor);
            }

            // Guarda el doctor y los horarios
            docServ.SaveDoctor(doctor);

            // Retorna el doctor guardado
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctor/borrar/{codigo_doctor}")
    public String deleteDoctor(@PathVariable Long codigo_doctor){
        docServ.deleteDoctor(codigo_doctor);
        return "fue borrada el doctor";


    }




    @PutMapping("/doctor/editar")
    public ResponseEntity<?> editDoctor(@RequestBody Doctor doctorRequest) {
        try {
            // Busca el doctor existente en la base de datos
            Doctor doctorExistente = docServ.findDoctor(doctorRequest.getCodigo_doctor());
            if (doctorExistente == null) {
                return new ResponseEntity<>("No se encontró el doctor con el código " + doctorRequest.getCodigo_doctor(), HttpStatus.NOT_FOUND);
            }

            // Actualiza los campos del doctor con los valores proporcionados en la solicitud, si no son null
            if (doctorRequest.getNombre() != null) {
                doctorExistente.setNombre(doctorRequest.getNombre());
            }
            if (doctorRequest.getApellido() != null) {
                doctorExistente.setApellido(doctorRequest.getApellido());
            }
            if (doctorRequest.getCedula() != 0) {
                doctorExistente.setCedula(doctorRequest.getCedula());
            }
            if (doctorRequest.getTelefono() != null) {
                doctorExistente.setTelefono(doctorRequest.getTelefono());
            }
            if (doctorRequest.getEspecialidad() != null) {
                doctorExistente.setEspecialidad(doctorRequest.getEspecialidad());
            }
            if (doctorRequest.getCorreoElectronico() != null) {
                doctorExistente.setCorreoElectronico(doctorRequest.getCorreoElectronico());
            }

            // Actualiza los horarios del doctor con los nuevos horarios proporcionados
            for (Horario horario : doctorRequest.getHorarios()) {
                Horario unHorario = horaServ.findHorario(horario.getHorario_id());
                if (unHorario != null) {
                    // Asigna el doctor al horario
                    unHorario.setDoctor(doctorExistente);
                }
            }

            // Guarda los cambios en el doctor
            docServ.SaveDoctor(doctorExistente);

            return new ResponseEntity<>("Doctor actualizado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
