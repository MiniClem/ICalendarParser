package tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AMUAde {
    private static final String url = "https://ade-web-consult.univ-amu.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?projectId=8&resources=4821&calType=ical&firstDate=%s&lastDate=%s";

    public static String getUrl(LocalDate from, LocalDate to) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        return String.format(url, dateTimeFormatter.format(from), dateTimeFormatter.format(to));
    }
}
