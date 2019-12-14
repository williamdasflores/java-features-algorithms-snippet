package functional;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Employee> employeeSupplier = () -> {
           return new Employee(5, "Sheila Silva", "Financial", new BigDecimal(6000),
                   Arrays.asList("Life Insurance", "Allowance Meal", "Home Office", "Health Insurance"));
        };

        Supplier<List<Employee>> employees = () -> new EmployeeData().getListEmployee();

        System.out.println("Employee: " + employeeSupplier.get());

        System.out.println("List of Employees: " + employees.get());
    }
}
