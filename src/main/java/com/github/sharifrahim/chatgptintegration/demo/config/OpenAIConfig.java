package com.github.sharifrahim.chatgptintegration.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

import lombok.extern.slf4j.Slf4j;

/**
 * Configuration class for setting up the OpenAI client.
 * <p>
 * This class creates a bean for the OpenAI client using the provided API key.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Slf4j
@Configuration
public class OpenAIConfig {

    /**
     * The API key for OpenAI, injected from the configuration property {@code openai.api.key}.
     */
    @Value("${openai.api.key}")
    private String openAiApiKey;

    /**
     * Creates and configures the OpenAI client bean.
     * <p>
     * The client is built using the {@code OpenAIOkHttpClient.builder()} by providing the API key.
     * </p>
     *
     * @return a fully configured instance of {@link OpenAIClient}.
     */
    @Bean
    public OpenAIClient openAiClient() {
        // Log the start of the client initialization process
        log.info("Initializing OpenAIClient bean with provided API key.");

        // Build the OpenAI client using the provided API key
        OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(openAiApiKey)
            .build();

        // Log successful creation of the client bean
        log.info("OpenAIClient bean created successfully.");

        return client;
    }
}
