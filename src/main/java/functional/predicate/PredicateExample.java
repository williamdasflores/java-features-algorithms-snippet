package functional.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    static  Predicate<Integer> number = (n) -> {  return n % 2 == 0; };
    static Predicate<Integer> number1 = n ->  n % 5 == 0;

    public static void main(String[] args) {
        System.out.println("Simple test predicate: " +number.test(3));

        System.out.println("'Predicate AND' Result:  " + number.and(number1).test(10));
        System.out.println("'Predicate AND' Result:  " + number.and(number1).test(15));

        System.out.println("'Predicate OR' Result: " +number.or(number1).test(15));
        System.out.println("'Predicate OR' Result: " +number.or(number1).test(9));

        System.out.println("'Predicate NEGATE' Result: " +number.and(number1).negate().test(10));
        System.out.println("'Predicate NEGATE' Result: " +number.and(number1).negate().test(15));

    }
}
