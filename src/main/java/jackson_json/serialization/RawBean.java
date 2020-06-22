package jackson_json.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RawBean {
    public String name;

    @JsonRawValue
    public String json;
}
