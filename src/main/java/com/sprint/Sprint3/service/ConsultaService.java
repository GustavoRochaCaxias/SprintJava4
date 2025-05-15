package com.sprint.Sprint3.service;

import com.sprint.Sprint3.models.Consulta;
import com.sprint.Sprint3.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public void salvar(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void excluir(Long id) {
        consultaRepository.deleteById(id);
    }
}