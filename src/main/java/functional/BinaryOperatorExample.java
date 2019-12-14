package functional;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer> comparator = (x, y) -> x.compareTo(y);

    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(10, 5));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("The MAX is " + maxBy.apply(15, 34));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("The MIN is " + minBy.apply(15, 34));
    }

}
