package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    private static Optional<List> listNumbers() {
        List<Integer> list = Arrays.asList(1,2,3,4,6,5);

        //return Optional.ofNullable(list);
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        Optional<List> optional = listNumbers();

        if (optional.isPresent())
            System.out.println(optional.get());
        else
            System.out.println("empty");

        System.out.println("orElse: " + optional.orElse(Arrays.asList(1,2)));
        System.out.println("orElseGet: " + optional.orElseGet(() -> Arrays.asList(3, 4)));
        optional.ifPresent(number -> System.out.println("it is present: " + number));
    }
}
