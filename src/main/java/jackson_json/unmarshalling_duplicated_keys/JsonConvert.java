package jackson_json.unmarshalling_duplicated_keys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Snippet example of how to convert an array with duplicated
 * keys
 */
public class JsonConvert {

    public static void main(String args[]) throws JsonProcessingException {
        String json = "{\n" +
                "\t\"id\" : \"5ee2e2f780bc8e7511a65de9\",\n" +
                "\t\"friends\": [{\n" +
                "\t\t\"friend\": {\n" +
                "\t\t\t\"id\": 1,\n" +
                "\t\t\t\"name\": \"Priscilla Lynch\"\n" +
                "\t\t},\n" +
                "\t\t\"friend\": {\n" +
                "\t\t\t\"id\": 2,\n" +
                "\t\t\t\"name\": \"William Lawrence\"\n" +
                "\t\t}\n" +
                "\t}]\n" +
                "}";

        convertToFriend(json);
    }

    public static void convertToFriend(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Contacts contacts = mapper.readValue(json, Contacts.class);

            System.out.println(contacts.getUnwrappedFriends().size());

            System.out.println(contacts);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
