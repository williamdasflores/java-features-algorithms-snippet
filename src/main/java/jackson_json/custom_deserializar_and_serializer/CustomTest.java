package jackson_json.custom_deserializar_and_serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CustomTest {

    @Test
    public void listToJsonTest() throws IOException {
        String jsonArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, " +
                "{ \"color\" : \"Red\", \"type\" : \"FIAT\" }]";

        ObjectMapper mapper = new ObjectMapper();
        List<Car> listCar = mapper.readValue(jsonArray,
                new TypeReference<List<Car>>(){});
        System.out.println(listCar);
        Assertions.assertTrue(listCar.size() > 0);
    }
}
