package com.example.security.securityexample.controller;



import com.example.security.securityexample.dto.PacienteDoctorDTO;
import com.example.security.securityexample.model.Doctor;
import com.example.security.securityexample.model.Paciente;
import com.example.security.securityexample.service.IDoctorService;
import com.example.security.securityexample.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PacienteController {
    @Autowired
    private IPacienteService paciServ;
    @Autowired
    private IDoctorService docServ;

    @GetMapping("/pacientes/traer")
    public List<Paciente> getPacientes(){

        return paciServ.getPacientes();
    }
    @GetMapping("pacientesdr/traer")
    public List<PacienteDoctorDTO> getpacientesDr(){
        List<Paciente> listaPaciente= paciServ.getPacientes();
        List<PacienteDoctorDTO> pacienteDoctorDTOList= new ArrayList<PacienteDoctorDTO>();
        for(Paciente paciente: listaPaciente){

            Long codigoDr= paciente.getUnDoctor().getCodigo_doctor();
            PacienteDoctorDTO pacienteDr= new PacienteDoctorDTO();
            pacienteDr.setCodigo_doctor(codigoDr);
            pacienteDr.setNombreDoctor(docServ.findDoctor(codigoDr).getNombre());
            pacienteDr.setApellidoDoctor(docServ.findDoctor(codigoDr).getApellido());
            pacienteDr.setCedulaDoctor(docServ.findDoctor(codigoDr).getCedula());
            pacienteDr.setCodigo_paciente(paciente.getCodigo_paciente());
            pacienteDr.setNombre(paciente.getNombre());
            pacienteDr.setApellido(paciente.getApellido());
            pacienteDr.setCedula(paciente.getCedula());
            pacienteDr.setSexo(paciente.getSexo());
            pacienteDr.setDireccion(paciente.getDireccion());
            pacienteDr.setTelefono(paciente.getTelefono());
            pacienteDr.setCorreoElectronico(paciente.getCorreoElectronico());
            pacienteDoctorDTOList.add(pacienteDr);
        }
        return pacienteDoctorDTOList;
    }
    @GetMapping("/pacientes/traer/{codigo_paciente}")
    public Paciente findPaciente(@PathVariable Long codigo_paciente){

        return  paciServ.findPaciente(codigo_paciente);
    }


    @PostMapping("/pacientes/crear/")
    public Paciente crearPaciente(@RequestBody PacienteDoctorDTO pacienteDoctorDTO){
        Doctor doctor= docServ.findDoctor(pacienteDoctorDTO.getCodigo_doctor());
        if(doctor== null){
            throw new RuntimeException("No existe el doctor");
        }
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDoctorDTO.getNombre());
        paciente.setApellido(pacienteDoctorDTO.getApellido());
        paciente.setCedula(pacienteDoctorDTO.getCedula());
        paciente.setSexo(pacienteDoctorDTO.getSexo());
        paciente.setCorreoElectronico(pacienteDoctorDTO.getCorreoElectronico());
        paciente.setDireccion(pacienteDoctorDTO.getDireccion());
        paciente.setTelefono(pacienteDoctorDTO.getTelefono());
        paciente.setUnDoctor(doctor);
        return paciServ.savePaciente(paciente);
    }


    @DeleteMapping("/pacientes/borrar/{codigo_paciente}")
    public String deletePaciente(@PathVariable Long codigo_paciente){
        paciServ.deletePaciente(codigo_paciente);
        return "fue borrada el paciente";
    }

    @PutMapping("/pacientes/editar")
    public String editPaciente(@RequestBody Paciente paciente){
        paciServ.editPaciente(paciente);
        return "se ha editado correctamente";
    }
}
