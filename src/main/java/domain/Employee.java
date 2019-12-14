package domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private int id;
    private String name;
    private String departament;
    private BigDecimal salary;
    private List<String> benefits;

    public Employee(String name) {
        this.name = name;
    }
}
