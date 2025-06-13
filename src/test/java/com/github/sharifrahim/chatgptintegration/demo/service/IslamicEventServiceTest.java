import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.sharifrahim.chatgptintegration.demo.dto.TimelineItemDTO;
import com.github.sharifrahim.chatgptintegration.demo.service.IslamicEventService;

class IslamicEventServiceTest {

    @Test
    void getIslamicEventsForCurrentYear_returnsExpectedEvents() {
        IslamicEventService service = new IslamicEventService();

        List<TimelineItemDTO> events = service.getIslamicEventsForCurrentYear();

        assertEquals(10, events.size(), "Should create ten timeline events");

        String[] names = {
            "Start of the Hijri Year",
            "Day of Ashura",
            "Mawlid an Nabi",
            "Isra and Miraj",
            "Nisf Shaban",
            "Start of Ramadan",
            "Battle of Badr",
            "Eid al Fitr",
            "Yawm Arafah",
            "Eid al Adha"
        };
        int[][] hijriDates = {
            {1, 1},
            {1, 10},
            {3, 12},
            {7, 27},
            {8, 15},
            {9, 1},
            {9, 17},
            {10, 1},
            {12, 9},
            {12, 10}
        };

        int currentHijriYear = HijrahDate.now().get(ChronoField.YEAR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < names.length; i++) {
            TimelineItemDTO item = events.get(i);
            assertEquals(i + 1, item.getId(), "Event ID should increment sequentially");
            assertEquals(names[i], item.getEventName());

            LocalDate expectedDate = LocalDate.from(HijrahDate.of(currentHijriYear, hijriDates[i][0], hijriDates[i][1]));
            assertEquals(expectedDate.format(formatter), item.getEventDate());
        }
    }
}
