package jackson_json.serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;


public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public ExtendableBean(String name) {
        this.name = name;
        properties = new HashMap<>();
    }

    public void add(String key, String value) {
        properties.put(key, value);
    }

    @JsonAnyGetter(enabled = false)
    public Map<String, String> getProperties() {
        return properties;
    }
}
