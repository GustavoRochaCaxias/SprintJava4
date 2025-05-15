package com.sprint.Sprint3.models;

import com.sprint.Sprint3.models.Paciente;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CONSULTAS")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSULTAID")
    private Long consultaId;

    @ManyToOne
    @JoinColumn(name = "PACIENTEID", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "DENTISTAID", nullable = false)
    private Dentista dentista;

    @Column(name = "DATACONSULTA")
    private Timestamp dataConsulta;

    @Column(name = "STATUSCONSULTA", length = 20)
    private String statusConsulta;


    @Lob
    @Column(name = "OBSERVACOES")
    private String observacoes;


    // Getters e Setters

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Timestamp getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Timestamp dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
