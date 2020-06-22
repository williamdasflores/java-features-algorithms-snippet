package jackson_json.unmarshalling_duplicated_keys;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Friends {

    // private Map<Integer, String> friends = new HashMap();
     private List<Friend> friends = new ArrayList();

    @JsonAnySetter
    public void setAny(String property,
                       Friend friend) {
        friends.add(friend);
    }

    public List<Friend> getFriends() {
        return friends;
    }
}
