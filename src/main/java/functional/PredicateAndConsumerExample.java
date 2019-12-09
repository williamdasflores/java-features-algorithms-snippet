package functional;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Employee> employeeP1 = emp -> emp.getSalary().compareTo(new BigDecimal(10000)) < 0;
    static Predicate<Employee> employeeP2 = emp -> "HR".equalsIgnoreCase(emp.getDepartament());
    static BiConsumer<String, List<String>> empBiConsumer = (name, benefits) -> System.out.println(name + " | " + benefits);
    static Consumer<Employee> employeeConsumer = employee -> {
        if (employeeP1.and(employeeP2).test(employee)) {
            empBiConsumer.accept(employee.getName(), employee.getBenefits());
        }
    };

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.getListEmployee().forEach(employeeConsumer);


    }
}
