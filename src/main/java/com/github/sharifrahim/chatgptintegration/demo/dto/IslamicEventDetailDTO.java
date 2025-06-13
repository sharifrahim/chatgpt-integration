package com.github.sharifrahim.chatgptintegration.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for providing detailed information about an Islamic event.
 * <p>
 * This DTO encapsulates the event's name, origin, reference links for the origin,
 * and related sunnah information along with its reference link. It is used for transferring
 * detailed event data between the service layer and presentation layer.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@NoArgsConstructor
@Data
public class IslamicEventDetailDTO {

    /**
     * The name of the Islamic event.
     */
    private String eventName;
    
    /**
     * The origin or source information related to the event.
     */
    private String origin;
    
    /**
     * The reference link providing additional details about the event's origin.
     */
    private String originRefLink;
    
    /**
     * The description of the sunnah related to the event.
     */
    private String sunnah;
    
    /**
     * The reference link providing additional details about the sunnah.
     */
    private String sunnahRefLink;
}
