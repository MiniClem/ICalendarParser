package properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Property {
    protected final List<Property> properties;


    public Property() {
        this.properties = new ArrayList<>();
    }

    abstract public void parse(Map<String, String> content);

    public void addProperty(Property p) {
        properties.add(p);
    }

    public List<Property> getProperties() {
        return properties;
    }
}
