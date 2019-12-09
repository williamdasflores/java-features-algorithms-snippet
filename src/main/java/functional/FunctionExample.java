package functional;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = (name) -> name.toUpperCase();
    static Function<String, String> addLastName = (name) -> name.toUpperCase().concat("Flores");
    public static void main(String[] args) {
        System.out.println("Result is: " +function.apply("william"));
        System.out.println("Result is: " +function.andThen(addLastName).apply("William "));
        System.out.println("Result is: " +function.compose(addLastName).apply("William "));
    }
}
