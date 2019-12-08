package functional.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Employee {
    private String name;
    private String departament;
    private BigDecimal salary;
    private List<String> benefits;
}
