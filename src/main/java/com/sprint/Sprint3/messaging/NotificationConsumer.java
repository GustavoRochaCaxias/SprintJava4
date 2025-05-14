package com.sprint.Sprint3.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "notificationQueue")
    public void receiveMessage(String message) {
        System.out.println("📥 Mensagem recebida: " + message);
    }
}
