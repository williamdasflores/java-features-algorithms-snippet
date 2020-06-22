package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class ExtendableBean {

    public String name;

    @Getter
    @Setter
    private Map<String, String> properties = new HashMap<>();

    /*
        @JsonAnySetter allow us to manipulate the json with Map
        See deserializationWithJsonAnySetter() into DeserializationTest.class.
        I deserialized json into properties.
     */
    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }
}
