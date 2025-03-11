package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for providing detailed information about a timeline event.
 * <p>
 * This DTO encapsulates the event's unique identifier, title, and detailed information
 * regarding its origin and associated sunnah, including reference links for further details.
 * It is used for transferring timeline event data between the service and presentation layers.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimelineDetailDTO {

    /**
     * Unique identifier for the timeline event.
     */
    private Long id;

    /**
     * Title of the timeline event.
     */
    private String title;

    /**
     * Information about the origin of the event.
     */
    private String origin;

    /**
     * Reference link or source related to the event's origin.
     */
    private String originRef;

    /**
     * Description of the sunnah associated with the event.
     */
    private String sunnah;

    /**
     * Reference link or source related to the sunnah.
     */
    private String sunnahRef;
}
