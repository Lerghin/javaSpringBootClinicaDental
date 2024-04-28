package com.example.security.securityexample.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_historia;

    @ManyToOne
    @JoinColumn(name = "codigo_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "codigo_doctor")
    private Doctor doctor;


    @OneToMany(mappedBy = "historiaClinica")
    private List<Cita> citas;

    private String diagnostico;
    private String secuenciaTratamiento;
    private Double debe;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long codigo_historia, Paciente paciente, Doctor doctor, List<Cita> citas, String diagnostico, String secuenciaTratamiento, Double debe) {
        this.codigo_historia = codigo_historia;
        this.paciente = paciente;
        this.doctor = doctor;

        this.citas = citas;
        this.diagnostico = diagnostico;
        this.secuenciaTratamiento = secuenciaTratamiento;
        this.debe = debe;
    }
}