package jackson_json.serialization;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
// @JsonPropertyOrder({ "name", "id" })
@JsonPropertyOrder(alphabetic = true)
public class MyBean {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    @JsonGetter("name")
    public String getAlternativeName() {
        return name;
    }
}
