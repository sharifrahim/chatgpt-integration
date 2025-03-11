package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.impl;

import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.IslamicEventDetailDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.MessageStrategy;

import lombok.Setter;

/**
 * Strategy implementation for retrieving detailed information about an Islamic event.
 * <p>
 * This class implements the {@link MessageStrategy} interface for {@link IslamicEventDetailDTO}.
 * It constructs a user message that incorporates the event name to request details such as the event's origin,
 * the recommended sunnah to follow on that day, and a reference link, all formatted as a paragraph.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
public class IslamicEvent implements MessageStrategy<IslamicEventDetailDTO> {

    /**
     * The name of the Islamic event for which details are requested.
     */
    @Setter
    private String eventName;

    /**
     * Constructs the user message to request details for the specified Islamic event.
     * <p>
     * The message instructs ChatGPT to provide the origin of the event, the recommended sunnah,
     * and include a reference link. The response should be in a paragraph format.
     * </p>
     *
     * @return the user message including the event name.
     */
    @Override
    public String getUserMessage() {
        // Construct and return the user message with the event name dynamically inserted.
        return "Get the origin of the event " + eventName + " and sunnah to do on the day. In a paragraph not list. Please include reference link.";
    }

    /**
     * Returns the expected response class type for deserializing the Islamic event details.
     *
     * @return {@code IslamicEventDetailDTO.class} representing the expected response type.
     */
    @Override
    public Class<IslamicEventDetailDTO> getResponseClass() {
        return IslamicEventDetailDTO.class;
    }
}
