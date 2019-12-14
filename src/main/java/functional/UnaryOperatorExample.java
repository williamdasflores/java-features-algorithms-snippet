package functional;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    // The input and output of this unaryOperator will be a String
    static UnaryOperator<String>  unaryOperator = (str) -> str.concat("hello!!!");

    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("William Flores "));
    }
}
