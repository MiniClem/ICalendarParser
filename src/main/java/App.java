import properties.Vcalendar;
import properties.Vevent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final Vcalendar vcalendar = ICalendarParser.parse(App.class.getResourceAsStream("ADECal.ics"));
        final List<Vevent> vevents = vcalendar.getVevents();
        for (Vevent vevent : vevents) {
            System.out.println(vevent.getDescriptionFormatted());
        }
        LocalDate from = LocalDate.of(2020, 11, 1);
        LocalDate to = LocalDate.of(2020, 11, 30);
        final String url = AMUAde.getUrl(from, to);
        try {
            InputStream inputStream = new URL(url).openStream();
            final Vcalendar vcalendar1 = ICalendarParser.parse(inputStream);
            final List<Vevent> vevents1 = vcalendar1.getVevents();
            System.out.println("Stop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
