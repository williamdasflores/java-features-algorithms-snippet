package data;

import domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmployeeData {

    private List<Employee> listEmployee = new ArrayList();

    public EmployeeData () {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("William Flores");
        employee.setDepartament("IT Innovation");
        employee.setSalary(new BigDecimal(10000));
        employee.setBenefits(Arrays.asList("Allowance Meal", "Home-Office", "Health Insurance",
                "Life Insurance", "Dental Insurance"));
        listEmployee.add(employee);

        Employee employee1 = new Employee(2, "Jéssica Souza", "HR", new BigDecimal(5000),
                Arrays.asList("Health Insurance", "Life Insurance", "Allowance Meal"));
        listEmployee.add(employee1);


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
}
