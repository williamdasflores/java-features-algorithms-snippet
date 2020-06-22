package jackson_json.serialization;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;

/**
 * By default, the name of wrapper would be
 * the name of class. However, using @JsonRootName
 * we are able to manipulate it.
 */
@JsonRootName(value = "root")
@AllArgsConstructor
public class UserRoot {
    public int id;
    public String name;
}
