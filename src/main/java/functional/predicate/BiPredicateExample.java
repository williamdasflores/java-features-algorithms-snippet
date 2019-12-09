package functional.predicate;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateExample {
    static BiPredicate<String, BigDecimal> biPredicate = (department, salary) ->
            "HR".equalsIgnoreCase(department) && salary.compareTo(new BigDecimal(2000)) < 0;

    static BiConsumer<String, List<String>> empBiConsumer = (name, benefits) -> System.out.println(name + " | " + benefits);
    static Consumer<Employee> employeeConsumer = employee -> {
       if (biPredicate.test(employee.getDepartament(), employee.getSalary())) {
           empBiConsumer.accept(employee.getName(), employee.getBenefits());
       }
    };

    public static void main(String[] args) {
        EmployeeData data = new EmployeeData();
        data.getListEmployee().forEach(employeeConsumer);
    }
}
