package method_reference;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReferenceExample {

    static UnaryOperator<String> toUpperCase = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUpperCase.apply("it is going to be uppercase"));
    }
}
