package functional;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    static Predicate<Employee> predicateEmployee = (employee -> employee.getSalary().compareTo(new BigDecimal(5000)) > 0);

    static BiFunction<List<Employee>, Predicate<Employee>, Map<String, BigDecimal>> employeeBiFunction =
        (employees, employeePredicate) -> {
           Map<String, BigDecimal> employeeMap = new HashMap<>();
           employees.forEach( employee -> {
               if (employeePredicate.test(employee)) {
                   employeeMap.put(employee.getName(), employee.getSalary());
               }
           });

           return employeeMap;
        } ;

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();
        System.out.println(employeeBiFunction.apply(employeeData.getListEmployee(), predicateEmployee));
    }
}
