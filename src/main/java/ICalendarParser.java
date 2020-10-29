import properties.Property;
import properties.PropertyFactory;
import properties.Vcalendar;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ICalendarParser {

    public static Vcalendar parse(InputStream is) {
        Scanner scanner = new Scanner(is);
        Stack<Property> contStack = new Stack<>();
        Stack<Map<String, String>> sStack = new Stack<>();

        String lastKey = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splits = line.split(":");

            switch (splits[0]) {
                case "BEGIN" -> {
                    Property property = PropertyFactory.getProperty(splits[1]);
                    contStack.push(property);
                    sStack.push(new HashMap<>());
                }
                case "END" -> {
                    Map<String, String> map = sStack.pop();
                    Property p = contStack.pop();
                    p.parse(map);
                    if (!contStack.empty()) {
                        Property pop = contStack.pop();
                        pop.addProperty(p);
                        contStack.push(pop);
                    } else return (Vcalendar) p;
                }
                default -> {
                    Map<String, String> m = sStack.pop();
                    if (line.startsWith(" ")) {
                        // Must modifiy last Entry instead of putting new one
                        if (lastKey != null) {
                            String lastValue = m.get(lastKey);
                            m.put(lastKey, lastValue + line.stripLeading());
                        } else
                            throw new IllegalStateException("Trying to append property value but no property stored");
                    } else {
                        try {
                            m.put(splits[0], splits.length > 1 ? splits[1] : "");
                            lastKey = splits[0];
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println(line);
                        }
                    }
                    sStack.push(m);
                }
            }
        }

        throw new IllegalArgumentException("There is no content to parse");
    }
}
