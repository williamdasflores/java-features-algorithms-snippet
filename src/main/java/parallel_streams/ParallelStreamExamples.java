package parallel_streams;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ParallelStreamExamples {

    private static void sum() {
        System.out.println("Sequential");
        long startTimeSequential = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000000).sum();
        long endTimeSequential = System.currentTimeMillis();
        System.out.println(endTimeSequential - startTimeSequential);

        System.out.println("Parallel");
        long startTimeParallel = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000000)
                .parallel()
                .sum();
        long endTimeParallel = System.currentTimeMillis();
        System.out.println(endTimeParallel - startTimeParallel);
    }

    private static void exampleNotToUseParallel() {
        List<Integer> integerList = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(toList());
        long sequentialStartTime = System.currentTimeMillis();
        integerList.stream().reduce(0, (x, y) -> x + y);
        long sequentialEndTime = System.currentTimeMillis();
        System.out.println(sequentialEndTime - sequentialStartTime);

        long parallelStartTime = System.currentTimeMillis();
        integerList.parallelStream().reduce(0, (x, y) -> x + y);
        long parallelEndTime = System.currentTimeMillis();
        System.out.println(parallelEndTime - parallelStartTime);
    }

    public static void exampleNotToUseParallel2() {
        for (int i = 0; i < 5; i++) {
            Sum sum = new Sum();
            IntStream.range(1, 10000)
                    .parallel()
                    .forEach(sum::performSum);
            System.out.println(sum.getTotal());
        }
    }

    public static void main(String[] args) {
        //sum();
        //exampleNotToUseParallel();
        exampleNotToUseParallel2();
    }
}

class Sum {
    private int total;

    public int getTotal() {
        return total;
    }

    public void performSum(int number) {
        this.total += number;
    }
}
