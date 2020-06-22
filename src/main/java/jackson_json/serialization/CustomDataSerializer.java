package jackson_json.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDataSerializer extends StdSerializer<LocalDateTime> {

    private static DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public CustomDataSerializer() {
        this(null);
    }

    public CustomDataSerializer(Class<LocalDateTime> dateTime) {
        super(dateTime);
    }

    @Override
    public void serialize(LocalDateTime dateTime,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(formatter.format(dateTime));
    }
}
