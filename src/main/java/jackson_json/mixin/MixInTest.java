package jackson_json.mixin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MixInTest {

    @Test
    public void mixInTest() throws JsonProcessingException {
        Item item = new Item(1, "cellphone", null);
        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(User.class, MixInForIgnoranceType.class);
        result = mapper.writeValueAsString(item);
        System.out.println(result);
        Assertions.assertTrue(!result.contains("owner"));

    }
}
