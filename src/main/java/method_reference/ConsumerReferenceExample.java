package method_reference;

import data.EmployeeData;
import domain.Employee;

import java.util.function.Consumer;

public class ConsumerReferenceExample {

    static Consumer<Employee> employeeConsumer = System.out::println;
    public static void main(String[] args) {
        new EmployeeData().getListEmployee().forEach(employeeConsumer);
    }
}
