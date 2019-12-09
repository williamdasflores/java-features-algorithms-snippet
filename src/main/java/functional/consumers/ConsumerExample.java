package functional.consumers;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Employee> empName = employee -> System.out.print(employee.getName());
        Consumer<Employee> empBenefits = employee -> System.out.println(employee.getBenefits());
        //List<Employee> listEmployee = getList();
        //getList().forEach(empName.andThen(empBenefits));
        List<Employee> listEmployee = getListByDepartment("IT Innovation");
        listEmployee.forEach(empName.andThen(empBenefits));
    }

    private static List getListByDepartment(String department) {
        EmployeeData employeeData = new EmployeeData();
        List<Employee> filteredList = new ArrayList<>();
        employeeData.getListEmployee().forEach( employee -> {
            if (department.equalsIgnoreCase(employee.getDepartament())) {
                filteredList.add(employee);
            }
        } );

        return filteredList;
    }

    private static List getList() {
        EmployeeData employeeData = new EmployeeData();
        return employeeData.getListEmployee();
    }

}
