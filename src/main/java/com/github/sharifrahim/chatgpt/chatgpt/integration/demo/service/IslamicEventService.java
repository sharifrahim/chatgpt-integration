package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.service;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto.TimelineItemDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class for handling Islamic events and generating timeline items for the current Hijri year.
 * <p>
 * This service computes the current Hijri year and converts specific Hijri dates to Gregorian dates.
 * It then creates a list of timeline events with their corresponding Gregorian dates.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Service
@Slf4j
public class IslamicEventService {

    /**
     * Counter to generate unique IDs for timeline events.
     */
    private long eventIdCounter = 1L;

    /**
     * Retrieves a list of timeline events for the current Hijri year.
     * <p>
     * The method computes the current Hijri year and creates timeline events for significant Islamic dates.
     * Each event's Hijri date is converted to a Gregorian date, and the event is added to the timeline list.
     * </p>
     *
     * @return a list of {@link TimelineItemDTO} representing the timeline events.
     */
    public List<TimelineItemDTO> getIslamicEventsForCurrentYear() {
        log.info("Fetching Islamic events for the current Hijri year.");
        List<TimelineItemDTO> timelineItemDTOs = new ArrayList<>();

        // Get the current Hijri date and extract the Hijri year
        HijrahDate currentHijriDate = HijrahDate.now();
        int currentHijriYear = currentHijriDate.get(ChronoField.YEAR);
        log.info("Current Hijri year: {}", currentHijriYear);

        // Add predefined Islamic events for the current Hijri year
        addEvent(currentHijriYear, 1, 1, "Start of the Hijri Year", timelineItemDTOs);
        addEvent(currentHijriYear, 1, 10, "Day of Ashura", timelineItemDTOs);
        addEvent(currentHijriYear, 3, 12, "Mawlid an Nabi", timelineItemDTOs);
        addEvent(currentHijriYear, 7, 27, "Isra and Miraj", timelineItemDTOs);
        addEvent(currentHijriYear, 8, 15, "Nisf Shaban", timelineItemDTOs);
        addEvent(currentHijriYear, 9, 1, "Start of Ramadan", timelineItemDTOs);
        addEvent(currentHijriYear, 9, 17, "Battle of Badr", timelineItemDTOs);
        addEvent(currentHijriYear, 10, 1, "Eid al Fitr", timelineItemDTOs);
        addEvent(currentHijriYear, 12, 9, "Yawm Arafah", timelineItemDTOs);
        addEvent(currentHijriYear, 12, 10, "Eid al Adha", timelineItemDTOs);

        log.info("Total {} events added for the current Hijri year.", timelineItemDTOs.size());
        return timelineItemDTOs;
    }

    /**
     * Adds an Islamic event to the timeline items list.
     * <p>
     * This method converts a given Hijri date to a Gregorian date format, creates a new
     * {@link TimelineItemDTO} for the event, and adds it to the provided list.
     * </p>
     *
     * @param hijriYear        the Hijri year of the event.
     * @param hijriMonth       the Hijri month of the event.
     * @param hijriDay         the Hijri day of the event.
     * @param eventName        the name of the event.
     * @param timelineItemDTOs the list to which the event will be added.
     * @return the updated list of timeline events.
     */
    private List<TimelineItemDTO> addEvent(int hijriYear, int hijriMonth, int hijriDay, String eventName,
                                           List<TimelineItemDTO> timelineItemDTOs) {
        // Create a HijrahDate instance for the specified event date
        HijrahDate eventHijriDate = HijrahDate.of(hijriYear, hijriMonth, hijriDay);
        // Convert the Hijri date to a Gregorian date
        LocalDate gregorianDate = LocalDate.from(eventHijriDate);
        // Define the desired Gregorian date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Create a new timeline item with a unique ID, event name, and formatted Gregorian date
        TimelineItemDTO timelineItem = new TimelineItemDTO(eventIdCounter, eventName, gregorianDate.format(formatter));
        timelineItemDTOs.add(timelineItem);
        log.info("Added event [{}] with Gregorian date: {}", eventName, gregorianDate.format(formatter));
        // Increment the event ID counter to maintain unique identifiers
        eventIdCounter++;
        return timelineItemDTOs;
    }
}
