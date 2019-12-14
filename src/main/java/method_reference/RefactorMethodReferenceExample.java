package method_reference;

import data.EmployeeData;
import domain.Employee;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    //static Predicate<Employee> employeePredicate = (employee -> employee.getSalary().compareTo(new BigDecimal(1000)) > 0);

    static Predicate<Employee> employeePredicate = RefactorMethodReferenceExample::greaterThanSalary;

    public static boolean greaterThanSalary(Employee employee) {
        return employee.getSalary().compareTo(new BigDecimal(1000)) > 0;
    }

    public static void main(String[] args) {
        System.out.println(employeePredicate.test(EmployeeData.employeeSupplier.get()));
    }
}
