package jackson_json.unmarshalling_duplicated_keys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class Contacts {

    String id;
    List<Friends> friends;

    public List<Friend> getUnwrappedFriends() {
        return friends.stream().flatMap(f -> f.getFriends().stream())
                .collect(Collectors.toList());
    }
}
