package data;

import domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class EmployeeData {

    public static Supplier<Employee> employeeSupplier = () -> {
        return new Employee(5, "Sheila Silva", "Financial", new BigDecimal(6000),
                Arrays.asList("Life Insurance", "Allowance Meal", "Home Office", "Health Insurance"));
    };

    private List<Employee> listEmployee = new ArrayList();

    public EmployeeData () {
        initEmployee();
    }

    public boolean createEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }

        listEmployee.add(employee);
        return true;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public Employee getEmployeeById(int id) {
       Employee employee = listEmployee.stream()
               .filter(emp -> emp.getId() == id)
               .findFirst().get();

       return employee;
    }

    private void initEmployee() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("William Flores");
        employee1.setDepartament("IT Innovation");
        employee1.setSalary(new BigDecimal(10000));
        employee1.setBenefits(Arrays.asList("Allowance Meal", "Home-Office", "Health Insurance",
                "Life Insurance", "Dental Insurance"));
        listEmployee.add(employee1);

        Employee employee2 = new Employee(2, "Jéssica Souza", "HR", new BigDecimal(5000),
                Arrays.asList("Health Insurance", "Life Insurance", "Allowance Meal"));
        listEmployee.add(employee2);

        Employee employee3 = new Employee(3, "João Marcos de Souza", "HR", new BigDecimal(2000),
                Arrays.asList("Health Insurance", "Life Insurance", "Allowance Meal", "Home Office"));
        listEmployee.add(employee3);

        Employee employee4 = new Employee(4, "Mariana Muller", "HR", new BigDecimal(800),
                Arrays.asList("Life Insurance", "Allowance Meal"));
        listEmployee.add(employee4);
    }
}
