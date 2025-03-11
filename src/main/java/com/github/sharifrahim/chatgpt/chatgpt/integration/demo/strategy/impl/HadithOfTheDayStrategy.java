package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.impl;

import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.HadithOfTheDayDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.MessageStrategy;

/**
 * Strategy implementation for fetching the Hadith of the Day.
 * <p>
 * This class implements the {@link MessageStrategy} interface for {@link HadithOfTheDayDTO}.
 * It provides the specific user message to request a random Islamic hadith and specifies the expected 
 * response type for deserialization.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
public class HadithOfTheDayStrategy implements MessageStrategy<HadithOfTheDayDTO> {

    /**
     * Returns the user message that will be sent to ChatGPT to fetch a random Islamic hadith.
     *
     * @return the user message as a {@code String}.
     */
    @Override
    public String getUserMessage() {
        // Return the predefined message for fetching a random Islamic hadith.
        return "Give me random islamic hadith";
    }

    /**
     * Returns the expected response class type for the Hadith of the Day.
     *
     * @return {@code HadithOfTheDayDTO.class} which represents the expected response type.
     */
    @Override
    public Class<HadithOfTheDayDTO> getResponseClass() {
        // Return the class type for deserialization of the Hadith of the Day response.
        return HadithOfTheDayDTO.class;
    }
}
