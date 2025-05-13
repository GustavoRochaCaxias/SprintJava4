package com.sprint.Sprint3.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "PACIENTES")
    public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PACIENTEID")
        private Long id;

        @Column(name = "NOME", nullable = false)
        private String nome;

        @Column(name = "DATANASCIMENTO", nullable = false)
        private LocalDate dataNascimento;

        @Column(name = "DATACADASTRO", nullable = false, updatable = false)
        private LocalDateTime dataCadastro = LocalDateTime.now();

        public Paciente() {}

        public Paciente(String nome, LocalDate dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.dataCadastro = LocalDateTime.now();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public LocalDate getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public LocalDateTime getDataCadastro() {
            return dataCadastro;
        }

        public void setDataCadastro(LocalDateTime dataCadastro) {
            this.dataCadastro = dataCadastro;
        }
    }

