package functional.consumers;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a,b) -> {
            System.out.println("a: " + a + " b: " +b);
        };
        //biConsumer.accept("William", "Flores");

        BiConsumer<Integer, Integer> multiply = (x, y) -> {
            System.out.println("Multiplication is: " + (x * y));
        };
        BiConsumer<Integer, Integer> division = (x, y) -> {
            System.out.println("Division is: " + (x / y));
        };

      multiply.andThen(division).accept(10, 2);

     }
}
