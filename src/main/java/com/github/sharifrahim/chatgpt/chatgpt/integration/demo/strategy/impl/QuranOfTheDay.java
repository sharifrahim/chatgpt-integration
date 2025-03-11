package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.impl;

import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.QuranOfTheDayDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.MessageStrategy;

/**
 * Strategy implementation for fetching the Quran of the Day.
 * <p>
 * This class implements the {@link MessageStrategy} interface for {@link QuranOfTheDayDTO}.
 * It provides the specific user message to request a random Quran verse and specifies the expected 
 * response type for deserialization.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
public class QuranOfTheDay implements MessageStrategy<QuranOfTheDayDTO>  {

    /**
     * Returns the user message to request a random Quran verse.
     *
     * @return the request message as a {@code String}.
     */
    @Override
    public String getUserMessage() {
        // Return the predefined message for fetching a random Quran verse.
        return "Get random quran verse.";
    }

    /**
     * Returns the expected response class type for the Quran of the Day.
     *
     * @return {@code QuranOfTheDayDTO.class} representing the expected response type.
     */
    @Override
    public Class<QuranOfTheDayDTO> getResponseClass() {
        // Return the class type for deserialization of the Quran of the Day response.
        return QuranOfTheDayDTO.class;
    }
}
