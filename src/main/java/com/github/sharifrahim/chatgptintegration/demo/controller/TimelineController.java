package com.github.sharifrahim.chatgptintegration.demo.controller;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.sharifrahim.chatgptintegration.demo.dto.HadithOfTheDayDTO;
import com.github.sharifrahim.chatgptintegration.demo.dto.QuranOfTheDayDTO;
import com.github.sharifrahim.chatgptintegration.demo.service.ChatGptService;
import com.github.sharifrahim.chatgptintegration.demo.strategy.impl.HadithOfTheDayStrategy;
import com.github.sharifrahim.chatgptintegration.demo.strategy.impl.QuranOfTheDay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller responsible for handling timeline requests.
 * <p>
 * This controller processes the timeline view which displays Islamic (Hijri) and Gregorian dates,
 * along with the Hadith and Quran of the day retrieved via the ChatGptService.
 * </p>
 * 
 * @author sharif
 * @see <a href="https://github.com/sharifrahim">https://github.com/sharifrahim</a>
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class TimelineController {
	
	/**
	 * Service for interacting with ChatGPT to retrieve daily content.
	 */
	private final ChatGptService chatGptService;

	/**
	 * Handles GET requests for the timeline page.
	 * <p>
	 * This method computes the Islamic (Hijri) and Gregorian dates, fetches the Hadith and Quran
	 * of the day using the ChatGptService, and adds them to the model to be rendered in the view.
	 * </p>
	 *
	 * @param model the Spring Model used to pass attributes to the view.
	 * @return the name of the view template for the timeline.
	 * @throws Exception if an error occurs during content retrieval.
	 */
	@GetMapping("/timeline")
	public String timeline(Model model) throws Exception {
	    log.info("Starting timeline endpoint");

		// Compute Islamic (Hijri) date
		HijrahDate hijrahDate = HijrahDate.now();
		DateTimeFormatter hijrahFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy G");
		String islamicDate = hijrahFormatter.format(hijrahDate);
		log.info("Computed Islamic (Hijri) date: {}", islamicDate);

		// Compute Gregorian date
		LocalDate today = LocalDate.now();
		DateTimeFormatter gregorianFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String gregorianDate = today.format(gregorianFormatter);
		log.info("Computed Gregorian date: {}", gregorianDate);

		// Retrieve Hadith of the Day values using ChatGptService
		HadithOfTheDayStrategy hadithOfTheDayStrategy = new HadithOfTheDayStrategy();
		HadithOfTheDayDTO hadith = chatGptService.getResponse(
		    hadithOfTheDayStrategy.getUserMessage(),
		    hadithOfTheDayStrategy.getResponseClass()
		);
		log.info("Fetched Hadith of the Day.");

		// Retrieve Quran of the Day values using ChatGptService
		QuranOfTheDay quranStrategy = new QuranOfTheDay();
		QuranOfTheDayDTO resultQuran = chatGptService.getResponse(
		    quranStrategy.getUserMessage(),
		    quranStrategy.getResponseClass()
		);
		log.info("Fetched Quran of the Day.");

		// Add all values to the model to be used in the view
		model.addAttribute("islamicDate", islamicDate);
		model.addAttribute("gregorianDate", gregorianDate);
		model.addAttribute("hadith", hadith);
		model.addAttribute("quran", resultQuran);
		log.info("Timeline data added to the model. Returning timeline view.");

		return "timeline";
	}
}
