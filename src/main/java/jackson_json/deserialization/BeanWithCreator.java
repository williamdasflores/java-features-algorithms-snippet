package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class BeanWithCreator {
    public int id;
    public String name;

    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theMainName") String name) {
        this.id = id;
        this.name = name;
    }
}
