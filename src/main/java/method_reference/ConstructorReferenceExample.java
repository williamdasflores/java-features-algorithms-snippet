package method_reference;

import domain.Employee;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    // It works: Supplier<Employee> employeeSupplier = Employee::new
    // It doesn't work: Employee employee = Employee::new

    static Supplier<Employee> employeeSupplier = Employee::new;

    static Function<String, Employee> employeeFunction = Employee::new;

    public static void main(String[] args) {
        System.out.println(employeeSupplier.get());
        System.out.println("--------------------------------------------------");
        System.out.println(employeeFunction.apply("Maria do Carmo"));
    }
}
