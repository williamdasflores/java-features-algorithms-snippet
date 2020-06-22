package jackson_json.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeserializationTest {

    @Test
    public void deserializationWithJsonCreator() throws IOException {
        String json = "{\"id\":1,\"theMainName\":\"MyBean\"}";
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        BeanWithCreator beanWithCreator = mapper
                .readerFor(BeanWithCreator.class)
                .readValue(json);
        System.out.println(beanWithCreator.toString());

        Assertions.assertTrue(beanWithCreator.name.equals("MyBean"));
    }

    @Test
    public void deserializationWithJacksonInject() throws IOException {
        String json = "{\"name\":\"MyBean\"}";
        InjectableValues injectableValues = new InjectableValues
                .Std()
                .addValue(int.class, 1);
        ObjectMapper mapper = new ObjectMapper();
        BeanWithInject bean = mapper.reader(injectableValues)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println(bean);

        Assertions.assertTrue(bean.name.equals("MyBean"));
        Assertions.assertTrue(bean.id == 1);
    }

    @Test
    public void deserializationWithJsonAnySetter() throws IOException {
        String json
                = "{\"name\":\"MyBean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        ObjectMapper mapper = new ObjectMapper();
        ExtendableBean bean = mapper.readerFor(ExtendableBean.class).readValue(json);
        System.out.println(bean);

        Assertions.assertTrue(bean.name.equals("MyBean"));
        Assertions.assertTrue(bean.getProperties().get("attr2").equals("val2"));
    }

    @Test
    public void deserializingWithJsonSetter() throws IOException {
        String json = "{\"id\":1,\"name\":\"MyBean\"}";
        System.out.println(json);

        MyBean bean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(json);

        System.out.println(bean);
        Assertions.assertTrue("MyBean".equals(bean.getName()));
    }

    @Test
    public void jsonPropertyTest() throws IOException {
        MyBean myBean = new MyBean();
        myBean.setId(1);
        myBean.setTheName("William");
        myBean.setTheAddress("BR/São Paulo");
        String result = new ObjectMapper().writeValueAsString(myBean);
        System.out.println(result);

        Assertions.assertTrue(result.contains("William"));

        MyBean unmarshilingBean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(result);
        System.out.println(unmarshilingBean);
        Assertions.assertTrue("William".equals(unmarshilingBean.getName()));
    }

    @Test
    public void jsonFormatTest() throws JsonProcessingException {
        LocalDateTime eventDate = LocalDateTime.of(2020, 6, 22, 8, 43, 00);
        Event event = new Event("marriage", eventDate);
        System.out.println(event);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void jsonUnwrapperTest() throws JsonProcessingException {
        UnwrapperUser.Name name = new UnwrapperUser.Name("John", "Doe");
        UnwrapperUser user = new UnwrapperUser(1, name);
        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);

        Assertions.assertTrue(result.contains("John"));
    }
}
