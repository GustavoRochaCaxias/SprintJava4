package com.sprint.Sprint3;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class ToolFeedbackOdonto {

    private final VectorStore vectors;

    public ToolFeedbackOdonto(VectorStore vectors) {
        this.vectors = vectors;
    }

    @Bean
    @Description("Salvar Feedback do Paciente")
    public Consumer<FeedbackPaciente> salvarFeedbackPaciente() {
        return feedback -> this.vectors.write(List.of(new Document(feedback.feedback)));
    }

    private record FeedbackPaciente(String feedback) {}
}
