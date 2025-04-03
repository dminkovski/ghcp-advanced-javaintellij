package microsoft.ghcp.advanced.GHCPDemo.proxy;// Copyright (c) Microsoft. All rights reserved.

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.ai.openai.responses.ResponsesClient;
import com.azure.ai.openai.responses.ResponsesClientBuilder;
import com.azure.ai.openai.responses.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.KeyCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.util.IterableStream;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Proxy to AzureOpenAI Service
 */
@Component
public class OpenAIProxy {

    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${azure.openai.key}")
    private String apiKey;

    @Value("${azure.openai.deployment}")
    private String deploymentName;

    private OpenAIClient client;

    @PostConstruct
    public void initialize() {
        this.client = new OpenAIClientBuilder()
                .endpoint(endpoint)
                .credential(new AzureKeyCredential(apiKey))
                .buildClient();
    }

    public OpenAIProxy() {
    }

    public String getResponse(String prompt) {
        try {
            List<ChatRequestMessage> chatMessages = new ArrayList<>();
            chatMessages.add(new ChatRequestSystemMessage("You are a username generator. All you do is return a single username. Examples: azure1, solarnova77"));
            chatMessages.add(new ChatRequestUserMessage(prompt));
            ChatCompletions chatCompletions = client.getChatCompletions(deploymentName,
                    new ChatCompletionsOptions(chatMessages));
            System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
            for (ChatChoice choice : chatCompletions.getChoices()) {
                ChatResponseMessage message = choice.getMessage();
                System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
                System.out.println("Message:");
                System.out.println(message.getContent());
            }
            return chatCompletions.getChoices().get(0).getMessage().getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}