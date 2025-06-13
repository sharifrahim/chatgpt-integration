package com.github.sharifrahim.chatgptintegration.demo.service;

/**
 * Service interface for interacting with ChatGPT.
 * <p>
 * This interface provides a method to send a user message to ChatGPT and
 * retrieve a response of a specified type. Implementations of this interface
 * should handle the communication with the ChatGPT API and return a response
 * matching the provided type.
 * </p>
 * 
 * @author sharif
 * @see <a href=
 *      "https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
public interface ChatGptService {

	/**
	 * Sends a user message to ChatGPT and retrieves a response of the specified
	 * type.
	 *
	 * @param userMessage  the message to be sent to ChatGPT.
	 * @param responseType the class type of the expected response.
	 * @param <T>          the type of the response.
	 * @return a response from ChatGPT of type {@code T}.
	 * @throws Exception if an error occurs during the communication or response
	 *                   parsing.
	 */
	public <T> T getResponse(String userMessage, Class<T> responseType) throws Exception;
}
