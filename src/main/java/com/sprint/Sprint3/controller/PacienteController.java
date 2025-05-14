package com.sprint.Sprint3.controller;

import com.sprint.Sprint3.messaging.NotificationProducer;
import com.sprint.Sprint3.models.Paciente;
import com.sprint.Sprint3.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    private final NotificationProducer notificationProducer;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository, NotificationProducer notificationProducer) {
        this.pacienteRepository = pacienteRepository;
        this.notificationProducer = notificationProducer;
    }

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "list-pacientes";
    }

    @GetMapping("/cadastrar")
    public String cadastrarPacienteForm() {
        return "cadastro-paciente";
    }

    @PostMapping
    public String cadastrarPaciente(@RequestParam String nome, @RequestParam String dataNascimento) {
        Paciente paciente = new Paciente(nome, LocalDate.parse(dataNascimento));
        pacienteRepository.save(paciente);

        // Enviar mensagem para RabbitMQ quando um paciente for adicionado
        notificationProducer.sendMessage("Paciente " + nome + " foi adicionado.");

        return "redirect:/pacientes";
    }

    @RequestMapping("/{id}")
    public String excluirPaciente(@PathVariable Long id) {
        if (pacienteRepository.existsById(id)) {
            Paciente paciente = pacienteRepository.findById(id).get();
            pacienteRepository.deleteById(id);

            notificationProducer.sendMessage("Paciente " + paciente.getNome() + " foi excluído.");
        }

        return "redirect:/pacientes";
    }
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado: " + id));
        model.addAttribute("paciente", paciente);
        return "editar-paciente";
    }
    @PutMapping("/{id}")
    public String atualizarPaciente(@PathVariable Long id, @RequestParam String nome, @RequestParam String dataNascimento) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado: " + id));

        paciente.setNome(nome);
        paciente.setDataNascimento(LocalDate.parse(dataNascimento));
        pacienteRepository.save(paciente);

        notificationProducer.sendMessage("Paciente " + nome + " foi atualizado.");

        return "redirect:/pacientes";
    }


}
