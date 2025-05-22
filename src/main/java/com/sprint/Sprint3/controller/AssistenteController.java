package com.sprint.Sprint3.controller;

import com.sprint.Sprint3.AssistenteOdonto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistente")
public class AssistenteController {

    private final AssistenteOdonto assistenteOdonto;

    public AssistenteController(AssistenteOdonto assistenteOdonto) {
        this.assistenteOdonto = assistenteOdonto;
    }

    @PostMapping("/conversar")
    public String resposta(@RequestParam String chatId, @RequestBody MensagemRequest request) {
        return assistenteOdonto.responder(chatId, request.mensagem());
    }

    public static record MensagemRequest(String mensagem) {}
}
