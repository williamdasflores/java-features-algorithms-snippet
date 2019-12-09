package functional.predicate;

import data.EmployeeData;
import domain.Employee;

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
        EmployeeData employeeData = new EmployeeData();

        Employee employee = new Employee(3, "Teresa Santos", "Financial", new BigDecimal(1000),
                Arrays.asList("Home Office", "Health Insurance", "Dental Insurance"));
        employeeData.createEmployee(employee);

        return employeeData.getListEmployee();
    }
}
