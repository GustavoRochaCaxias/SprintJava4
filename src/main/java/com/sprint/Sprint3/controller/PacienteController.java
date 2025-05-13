package com.sprint.Sprint3.controller;

import com.sprint.Sprint3.models.Paciente;
import com.sprint.Sprint3.repositories.PacienteRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "list-pacientes";
    }

    @GetMapping("/cadastrar")
    @Secured("ROLE_ADMIN")
    public String cadastrarPacienteForm() {
        return "cadastro-paciente";
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public String cadastrarPaciente(@RequestParam String nome, @RequestParam String dataNascimento) {
        Paciente paciente = new Paciente(nome, LocalDate.parse(dataNascimento));
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/{id}/editar")
    @Secured("ROLE_ADMIN")
    public String editarPaciente(@PathVariable Long id, Model model) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "editar-paciente";
        } else {
            return "redirect:/pacientes";
        }
    }

    @PostMapping("/{id}/editar")
    @Secured("ROLE_ADMIN")
    public String atualizarPaciente(@PathVariable Long id, @RequestParam String nome, @RequestParam String dataNascimento) {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);

        if (pacienteExistente.isPresent()) {
            Paciente paciente = pacienteExistente.get();
            paciente.setNome(nome);
            paciente.setDataNascimento(LocalDate.parse(dataNascimento));
            pacienteRepository.save(paciente);
            return "redirect:/pacientes";
        } else {
            return "redirect:/pacientes";
        }
    }

    @RequestMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public String excluirPaciente(@PathVariable Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        }
        return "redirect:/pacientes";
    }
}
