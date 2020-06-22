package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class Event {
    public String name;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy HH:mm")
    public LocalDateTime eventDate;
}
