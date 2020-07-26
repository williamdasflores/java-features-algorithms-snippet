package streams;

import streams.beans.Employee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StatefulStreamExample {

    public static void main(String ...args) {
        Employee emp1 = new Employee("William", new BigDecimal("3000"));
        Employee emp2 = new Employee("John", new BigDecimal("5000"));
        Employee emp3 = new Employee("Jeniffer", new BigDecimal("3500"));
        Employee emp4 = new Employee("Rachel", new BigDecimal("1500"));
        List<Employee> listOfEmployees = Arrays.asList(emp1,emp2,emp3,emp4);

        listOfEmployees.stream()
                .filter(employee -> {
                    System.out.println("Employee: " + employee.getName());
                    return employee.getSalary().compareTo(new BigDecimal("3000")) < 1;
                })
                .sorted()
                .map(employee -> {
                    System.out.println("Mapping employee: " + employee.getName());
                    return new Employee(employee.getName(), employee.getSalary().multiply(new BigDecimal("1.05")));
                })
                .collect(toList());
    }
}
