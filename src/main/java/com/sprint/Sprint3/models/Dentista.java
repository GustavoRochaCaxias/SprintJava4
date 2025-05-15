package com.sprint.Sprint3.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DENTISTAS")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DENTISTAID")
    private Long dentistaId;

    @Column(name = "NOME", length = 255)
    private String nome;

    @Column(name = "CRO", length = 50)
    private String cro;

    @Column(name = "ESPECIALIZACAO", length = 100)
    private String especializacao;

    @Column(name = "DATAADMISSAO")
    private Timestamp dataAdmissao;

    // Getters e setters

    public Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Timestamp getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Timestamp dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
