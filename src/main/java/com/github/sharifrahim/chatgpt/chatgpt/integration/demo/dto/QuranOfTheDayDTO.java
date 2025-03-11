package com.github.sharifrahim.chatgpt.chatgpt.integration.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing the Quran of the Day.
 * <p>
 * This DTO encapsulates the daily Quran content, including its translation,
 * the surah (chapter), and the specific ayat (verse). It is used to transfer the Quran daily
 * readings between the service and presentation layers.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@NoArgsConstructor
@Data
public class QuranOfTheDayDTO {

    /**
     * The translation text of the Quran for the day.
     */
    private String quranTranslation;

    /**
     * The name or number of the surah (chapter) associated with the daily reading.
     */
    private String surah;

    /**
     * The specific ayat (verse) associated with the daily reading.
     */
    private String ayat;
}

