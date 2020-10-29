package properties;

import java.util.*;

public class Vcalendar extends Property {
    private String VERSION;
    private String PRODID;
    private String METHOD;
    private String CALSCALE;

    public Vcalendar() {
        super();
    }

    @Override
    public void parse(Map<String, String> content) {
        Set<Map.Entry<String, String>> entries = content.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            switch (entry.getKey()) {
                case "VERSION" -> VERSION = entry.getValue();
                case "PRODID" -> PRODID = entry.getValue();
                case "METHOD" -> METHOD = entry.getValue();
                case "CALSCALE" -> CALSCALE = entry.getValue();
            }
        }
    }

    public List<Vevent> getVevents() {
        final List<Property> properties = getProperties();
        final List<Vevent> vevents = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof Vevent)
                vevents.add((Vevent) property);
        }
        Collections.sort(vevents);
        return vevents;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public String getCALSCALE() {
        return CALSCALE;
    }

    public String getVERSION() {
        return VERSION;
    }

    public String getPRODID() {
        return PRODID;
    }
}
