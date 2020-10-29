import properties.Vcalendar;
import properties.Vevent;

import java.util.List;

public class App {
    public static void main(String[] args) {
        final Vcalendar vcalendar = ICalendarParser.parse(App.class.getResourceAsStream("ADECal.ics"));
        final List<Vevent> vevents = vcalendar.getVevents();
        System.out.println("Stop");
    }
}
