package jackson_json.deserialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class MyBean {

    @Setter
    public int id;

    private String name;
    private String address;

    @JsonProperty("address")
    public String getTheAddress() {
        return address;
    }
    @JsonProperty("address")
    public void setTheAddress(String address) {
        this.address = address;
    }

    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
