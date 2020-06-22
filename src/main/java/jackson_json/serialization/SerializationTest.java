package jackson_json.serialization;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SerializationTest {

    @Test
    public void serializingUsingJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My Bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        Assertions.assertTrue(result.contains("attr1"));
        Assertions.assertTrue(result.contains("val1"));
    }

    @Test
    public void serilizingUsingJsonGetter() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "MyBean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        Assertions.assertTrue(result.contains("MyBean"));
        Assertions.assertTrue(result.contains("1"));
    }

    @Test
    public void usingJsonPropertyOrder() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "MyBean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        Assertions.assertTrue(result.contains("MyBean"));
        Assertions.assertTrue(result.contains("1"));
    }

    @Test
    public void usingJsonRaw() throws JsonProcessingException {
        RawBean rawBean = new RawBean("RawBean", "{attibuteJson: true}");
        String result = new ObjectMapper().writeValueAsString(rawBean);
        System.out.println(result);

        Assertions.assertTrue(result.contains("RawBean"));
    }

    @Test
    public void serilizingUsingJsonValue() throws JsonProcessingException {
        String enumAsString = new ObjectMapper()
                .writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println(enumAsString);
        Assertions.assertTrue(true);
    }

    @Test
    public void serializingUsingJsonRootName() throws JsonProcessingException{
        UserRoot userRoot = new UserRoot(1, "William");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(userRoot);
        System.out.println(result);

        Assertions.assertTrue(result.contains("root"));
        Assertions.assertTrue(result.contains("William"));
    }

    @Test
    public void serializingUsingJsonSerializer() throws JsonProcessingException {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String newDateFormatter = dateTimeNow.format(df);

        Event event = new Event("party", dateTimeNow);
        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(event);
        System.out.println(result);

        Assertions.assertTrue(result.contains(newDateFormatter));
    }

 }
