package functional.predicate;

import functional.domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEmployeeExample {

    static Predicate<Employee> emp1 = (employee) -> employee.getSalary().compareTo(new BigDecimal(1000)) <= 0;

    public static void main(String[] args) {
        List<Employee> listEmployee = getList();
        listEmployee.forEach( employee -> {
            if (emp1.test(employee))
                System.out.println(employee.getName());
        });

    }

    private static List getList() {
        List list = new ArrayList();
        Employee emp1 = new Employee("William", "Innovation", new BigDecimal(10000),
                Arrays.asList("Transport, Car, Vacation"));
        list.add(emp1);
        Employee emp2 = new Employee("Fernanda", "HR", new BigDecimal(1000),
                Arrays.asList("Home-Office", "Transportation", "Car"));
        list.add(emp2);

        return list;
    }
}
