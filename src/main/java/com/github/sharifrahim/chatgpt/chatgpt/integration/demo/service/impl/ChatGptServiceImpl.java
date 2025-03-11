package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.service.ChatGptService;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of the {@link ChatGptService} interface that interacts with the ChatGPT API.
 * <p>
 * This service sends a user message to ChatGPT, specifies an expected JSON response format,
 * retrieves the response, and deserializes it into the desired type.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ChatGptServiceImpl implements ChatGptService {

    /**
     * The OpenAI client used to interact with the ChatGPT API.
     */
    private final OpenAIClient openAiClient;

    /**
     * Sends a user message to ChatGPT and retrieves a response of the specified type.
     * <p>
     * This method constructs the API request by first determining the expected JSON format
     * using an empty instance of the response type. It then builds the request parameters including
     * a system message that instructs ChatGPT to respond only in that JSON format. The method sends
     * the request, cleans up any markdown formatting from the response, and finally deserializes the
     * JSON into the desired response type.
     * </p>
     *
     * @param userMessage the message to be processed by ChatGPT.
     * @param responseType the class type of the expected response.
     * @param <T> the type of the response.
     * @return a deserialized response of type {@code T}.
     * @throws Exception if an error occurs during communication or deserialization.
     */
    @Override
    public <T> T getResponse(String userMessage, Class<T> responseType) throws Exception {
        // Log the start of the response retrieval process.
        log.info("Sending message to ChatGPT: {}", userMessage);

        // Create an empty instance of the response type to generate the expected JSON format.
        T instance = responseType.getDeclaredConstructor().newInstance();
        String exampleJsonFormat = new ObjectMapper().writeValueAsString(instance);
        log.debug("Expected JSON format: {}", exampleJsonFormat);

        // Build the parameters for the chat completion request.
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
            .addUserMessage(userMessage)
            .addSystemMessage("Response in this json format : " + exampleJsonFormat + ". Only output JSON.")
            .model(ChatModel.GPT_4O_2024_11_20)
            .build();
        log.info("ChatCompletionCreateParams built with model: {}", ChatModel.GPT_4O_2024_11_20);

        // Send the request using the OpenAI client and receive the chat completion.
        ChatCompletion chatCompletion = openAiClient.chat().completions().create(params);
        log.info("Received response from ChatGPT.");

        // Extract the content from the first choice in the response.
        String jsonResponse = chatCompletion.choices().get(0).message().content().orElseThrow();
        log.debug("Raw JSON response: {}", jsonResponse);

        // Remove markdown formatting if present
        if (jsonResponse.startsWith("```")) {
            // Find the first newline after the opening triple backticks.
            int firstNewline = jsonResponse.indexOf("\n");
            if (firstNewline != -1) {
                jsonResponse = jsonResponse.substring(firstNewline + 1);
            }
        }
        if (jsonResponse.endsWith("```")) {
            jsonResponse = jsonResponse.substring(0, jsonResponse.lastIndexOf("```"));
        }
        jsonResponse = jsonResponse.trim();
        log.debug("Processed JSON response: {}", jsonResponse);

        // Deserialize the JSON response into the expected response type.
        T response = new ObjectMapper().readValue(jsonResponse, responseType);
        log.info("Deserialized response into type: {}", responseType.getSimpleName());
        return response;
    }
}
