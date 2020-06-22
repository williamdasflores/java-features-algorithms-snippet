package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UnwrapperUser {
    public int id;

    @JsonUnwrapped
    public Name name;
    @ToString
    public static class Name {
        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastname = lastName;
        }
        public String firstName;
        public String lastname;
    }

}


