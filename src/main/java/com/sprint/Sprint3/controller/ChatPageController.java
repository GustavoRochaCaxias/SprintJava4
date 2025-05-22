package com.sprint.Sprint3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String abrirChat() {
        return "chat"; // Isso renderiza o arquivo `chat.html`
    }
}