package com.github.sharifrahim.chatgptintegration.demo.strategy;

/**
 * Strategy interface for defining message behavior for ChatGPT interactions.
 * <p>
 * Implementations of this interface provide the user message to be sent to ChatGPT and
 * specify the expected response type for deserialization.
 * </p>
 * 
 * @param <T> the type of the response expected from ChatGPT.
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
public interface MessageStrategy<T> {

    /**
     * Retrieves the user message that will be sent to ChatGPT.
     *
     * @return the user message as a {@code String}.
     */
    public String getUserMessage();

    /**
     * Retrieves the response class type used for deserializing the ChatGPT response.
     *
     * @return the {@code Class} representing the expected response type.
     */
    public Class<T> getResponseClass();
}
