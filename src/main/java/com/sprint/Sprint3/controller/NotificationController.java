package com.sprint.Sprint3.controller;

import com.sprint.Sprint3.messaging.NotificationProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacoes")
public class NotificationController {

    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/enviar")
    public String enviarMensagem(@RequestBody String mensagem) {
        producer.sendMessage(mensagem);
        return "Mensagem enviada!";
    }
}
