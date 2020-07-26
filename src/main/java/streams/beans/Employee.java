package streams.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee implements Comparable{

    private String name;
    private BigDecimal salary;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
