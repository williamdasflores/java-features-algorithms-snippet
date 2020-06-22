package jackson_json.serialization;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Event {
    public String name;

    @JsonSerialize(using = CustomDataSerializer.class)
    public LocalDateTime eventDate;
}
