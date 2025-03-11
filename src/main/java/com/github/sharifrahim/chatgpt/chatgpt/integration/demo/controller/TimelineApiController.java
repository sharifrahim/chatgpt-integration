package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.IslamicEventDetailDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.TimelineDetailDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.TimelineItemDTO;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.service.ChatGptService;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.service.IslamicEventService;
import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.strategy.impl.IslamicEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing Islamic timeline events.
 * <p>
 * This controller provides endpoints to retrieve timeline events and detailed information for a specific event.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/timeline")
public class TimelineApiController {

    /**
     * Service for handling ChatGPT-related operations.
     */
    private final ChatGptService chatGptService;

    /**
     * Service for retrieving Islamic events.
     */
    private final IslamicEventService islamicEventService;

    /**
     * Endpoint to fetch Islamic timeline events for the current year.
     *
     * @return a list of {@link TimelineItemDTO} representing timeline items.
     * @throws Exception if an error occurs while fetching the events.
     */
    @GetMapping
    public List<TimelineItemDTO> getTimelineItems() throws Exception {
        // Log the beginning of the request processing
        log.info("Fetching Islamic timeline events for the current year.");
        
        // Retrieve the list of timeline events from the IslamicEventService
        List<TimelineItemDTO> timelineItems = islamicEventService.getIslamicEventsForCurrentYear();
        
        // Log the successful retrieval along with the number of items returned
        log.info("Fetched {} timeline items.", timelineItems.size());
        
        return timelineItems;
    }

    /**
     * Endpoint to fetch detailed information for a given Islamic event.
     * <p>
     * Accepts the {@code eventName} query parameter from the frontend to identify the event.
     * </p>
     *
     * @param id the unique identifier of the timeline event.
     * @param eventName the name of the Islamic event.
     * @return a {@link TimelineDetailDTO} containing detailed event information.
     * @throws Exception if an error occurs while fetching the event details.
     */
    @GetMapping("/{id}")
    public TimelineDetailDTO getTimelineDetail(@PathVariable Long id, @RequestParam String eventName) throws Exception {
        // Log the start of detailed event information retrieval
        log.info("Fetching detailed information for event with id: {} and eventName: {}", id, eventName);

        // Create a new IslamicEvent instance and set the event name from the request
        IslamicEvent message = new IslamicEvent();
        message.setEventName(eventName);

        // Retrieve event details using ChatGptService
        IslamicEventDetailDTO eventDetail = chatGptService.getResponse(message.getUserMessage(), message.getResponseClass());
        log.info("Received event details from ChatGptService for event: {}", eventName);

        // Construct the TimelineDetailDTO using the retrieved event details
        TimelineDetailDTO detailDTO = new TimelineDetailDTO(
                id,
                eventName,
                eventDetail.getOrigin(),
                eventDetail.getOriginRefLink(),
                eventDetail.getSunnah(),
                eventDetail.getSunnahRefLInk()
        );
        
        // Log completion of the detailed event information retrieval
        log.info("Returning detailed event information for event: {}", eventName);
        return detailDTO;
    }
}
