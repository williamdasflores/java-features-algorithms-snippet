package jackson_json.serialization;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEnumWithValue {
    TYPE1(1, "Type 1"),
    TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    @JsonValue
    public String getName() {
        return name;
    }
}
