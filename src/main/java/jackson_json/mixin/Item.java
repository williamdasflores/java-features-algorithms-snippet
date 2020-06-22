package jackson_json.mixin;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Item {
    public int id;
    public String itemName;
    public User owner;

}
