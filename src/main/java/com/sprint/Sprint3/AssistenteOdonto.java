package com.sprint.Sprint3;

import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;
import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;



@Service
public class AssistenteOdonto {

    private final ChatClient chat;

    public AssistenteOdonto(ChatClient.Builder builder, VectorStore vectors, ChatMemory memory) {
        this.chat = builder
                .defaultSystem("""
                    Você é um assistente virtual de um consultório odontológico.
                    Seu papel é auxiliar com dúvidas sobre tratamentos, agendamentos, procedimentos e orientações aos pacientes.
                    Sempre seja claro, empático e evite termos técnicos difíceis sem explicação.
                    Caso a pergunta envolva dados do sistema (como pacientes ou consultas), utilize funções quando necessário.
                    Hoje é {current_date}.
                """)
                .defaultAdvisors(new PromptChatMemoryAdvisor(memory), new QuestionAnswerAdvisor(vectors))
                .defaultFunctions("listarProcedimentos", "consultarPaciente", "agendarConsulta")
                .build();
    }

    public String responder(String chatId, String mensagem) {
        Response resposta = this.chat.prompt()
                .system(s -> s.param("current_date", LocalDate.now().toString()))
                .user(mensagem)
                .advisors(a -> a
                        .param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 100)
                )
                .call().entity(Response.class);
        return resposta.response;
    }

    private record Response(String response) {}
}

