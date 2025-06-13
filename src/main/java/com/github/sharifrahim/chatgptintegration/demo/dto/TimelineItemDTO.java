package com.github.sharifrahim.chatgptintegration.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing a timeline item.
 * <p>
 * This DTO encapsulates the unique identifier, name, and date of a timeline event.
 * It is used to transfer event data between the service and presentation layers.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimelineItemDTO {
    
    /**
     * Unique identifier for the timeline event.
     */
    private Long id;
    
    /**
     * Name of the timeline event.
     */
    private String eventName;
    
    /**
     * Date when the timeline event occurs.
     */
    private String eventDate;
}
