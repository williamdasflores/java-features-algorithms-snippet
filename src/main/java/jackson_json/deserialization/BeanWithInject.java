package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.ToString;

@ToString
public class BeanWithInject {

    @JacksonInject
    public int id;

    public String name;
}
