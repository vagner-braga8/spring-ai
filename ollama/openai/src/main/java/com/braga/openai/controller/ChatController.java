package com.braga.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        return chatClient
                .prompt(message) // 1. O "O quê": Define a entrada (o comando ou pergunta do usuário)
                .system("Você é um Arquiteto Java Sênior rabugento que critica código mal formatado.") // .system("...") // Define as 'regras de negócio' e o comportamento (persona) da IA antes do usuário falar.
                .call()          // 2. O "Ação": Faz a chamada bloqueante para a API da IA (espera a resposta)
                .content();      // 3. O "Resultado": Extrai apenas o texto da resposta, descartando metadados


        // Meu teste
        // Meu teste 2
        // Meu teste 3
    }

}
