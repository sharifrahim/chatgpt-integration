package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing the Hadith of the Day.
 * <p>
 * This DTO encapsulates the details of the hadith content, including its text,
 * status, and reference information. It is used to transfer data between the
 * service layer and the presentation layer.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HadithOfTheDayDTO {

    /**
     * The textual content of the hadith.
     */
    private String content;

    /**
     * The status indicating the retrieval state or validity of the hadith.
     */
    private String status;

    /**
     * The reference from which the hadith is derived.
     */
    private String reference;
}
