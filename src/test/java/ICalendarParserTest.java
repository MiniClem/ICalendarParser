import org.junit.jupiter.api.Test;
import properties.Vcalendar;
import properties.Vevent;
import tools.ICalendarParser;

import java.io.InputStream;

class ICalendarParserTest {

    static String CALENDAR_SAMPLE_FILE = "calendar_sample.ics";

    @Test
    void test_parsing() {
        InputStream fs = getClass().getClassLoader().getResourceAsStream(CALENDAR_SAMPLE_FILE);
        Vcalendar vcalendar = ICalendarParser.parse(fs);
        System.out.println(((Vevent) vcalendar.getProperties().get(0)).getDESCRIPTION());
    }
}