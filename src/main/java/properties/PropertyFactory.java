package properties;

public class PropertyFactory {

    public static Property getProperty(String name) {
        return switch (name.toLowerCase()) {
            case "vcalendar" -> new Vcalendar();
            case "vevent" -> new Vevent();
            default -> null;
        };
    }
}
