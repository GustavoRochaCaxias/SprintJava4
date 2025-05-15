package com.sprint.Sprint3.controller;

import com.sprint.Sprint3.models.Consulta;
import com.sprint.Sprint3.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping("/consultas")
    public String listarConsultas(Model model) {
        List<Consulta> consultas = consultaRepository.findAll();
        model.addAttribute("consultas", consultas);
        return "consultas";
    }

    @GetMapping("/consultas/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "form-consulta";
    }

    @PostMapping("/consultas/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/consultas/editar/{id}")
    public String editarConsulta(@PathVariable Long id, Model model) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        model.addAttribute("consulta", consulta);
        return "form-consulta";
    }

    @GetMapping("/consultas/deletar/{id}")
    public String deletarConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
        return "redirect:/consultas";
    }
}
