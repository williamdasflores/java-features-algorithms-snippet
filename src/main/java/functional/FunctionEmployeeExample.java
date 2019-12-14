package functional;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionEmployeeExample {

    static Predicate<Employee> employeePredicate = (employee )-> employee.getSalary().compareTo(new BigDecimal(2000)) > 0;

    static Function<List<Employee>, Map<String, BigDecimal>> employeeFunction = (employees -> {
       Map<String, BigDecimal> employeeSalaryMap = new HashMap<>();

        employees.forEach((employee -> {
            if (employeePredicate.test(employee)) {
                employeeSalaryMap.put(employee.getName(), employee.getSalary());
            }
        }));

        return employeeSalaryMap;
    });

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();
        System.out.println(employeeFunction.apply(employeeData.getListEmployee()));
    }
}
