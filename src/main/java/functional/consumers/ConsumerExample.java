package functional.consumers;

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
        List<Employee> listEmployee = getListByDepartment("Innovation");
        listEmployee.forEach(empName.andThen(empBenefits));
    }

    private static List getListByDepartment(String department) {
        List<Employee> filteredList = new ArrayList<>();
        List<Employee> listAllEmployee = getList();
        listAllEmployee.forEach( employee -> {
            if (department.equalsIgnoreCase(employee.getDepartament())) {
                filteredList.add(employee);
            }
        } );

        return filteredList;
    }

    private static List getList() {
        List list = new ArrayList();
        Employee emp1 = new Employee("William", "Innovation", new BigDecimal(10000),
                Arrays.asList("Transport, Car, Vacation"));
        list.add(emp1);
        Employee emp2 = new Employee("Fernanda", "HR", new BigDecimal(1000),
                Arrays.asList("Home-Office", "Transportation", "Car"));
        list.add(emp2);

        return list;
    }

}
