package algorithms;

/**
 * Big O notation is used to evaluate how quickly the runtime
 * grows relative to the input data to be processed by that
 * algorithm.
 * Big O favors the worst-case performance scenario.
 * Time Complexity -> The time complexity of an algorithm determines the number
 * of steps taken by the algorithm, measured with respect to "n"(input data to be processed),
 * the size of the input.
 * Space Complexity -> The space complexity of an algorithm determines the amount of space
 * required by the algorithm to execute, measured with respect to "n"(input data to be processed).
 */
public class BigONotationsExamples {
    String[] names = { "William", "John", "Rachel", "Catharine" };
    Integer[] numbers = { 0,1,2,3,4,5,6,7,8,9 };

    /**
     * Constant | O(1) -> The time is constant with respect to the size
     * of the input
     * As an example, the method below takes the same to run no matter
     * the number of the item in the array.
     *
     */
    public int constantExample(Object[] array) {
        return array.length;
    }

    /**
     * Linear | 0(n) -> As I mentioned before, Big O favors the worst-case
     * performance; for example, a case where we are looking for a matching
     * number in an array of number which could be found during any iteration of
     * the "for" loop and the function would return earlu. Big O notation will
     * always assume the upper limit where the algorithm will perform the maximum
     * number of iterations to find the matching number (if the number was the last
     * item stored in the array.
     *
     */
    public boolean linearExample(Object item, Object[] array) {
        for (Object i : array) {
            if (i == item || i.equals(item))
                return true;
        }
        return false;
    }

    /**
     * Quadratic | O(n^2) -> It performance is directly proportional to the square
     * to the square of the size of the input data set.
     * A nested iteration over input data (such as nest "for" loop) is a common
     * example of a script or algorithm that involve quadratic runtime.
     * Thus, deeper nested iterations will result in O(n^3), O(n^4), etc
     *
     */
    public void quadraticExample(Object[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = array.length -1; j >= 0; j--) {
                System.out.print(array[j]);
                System.out.print(" ");
            }
            System.out.println(array[i]);
        }

    }

    /**
     * Logarithmic | O(log n)
     * A common example to explain logarithmic is Binary search concept.
     * -> Best case scenario is when the element is stored in the middle.
     * -> Worst case scenario is when the element is stored either at beginning or end.
     *
     */
    public boolean logarithmic(int number, Integer[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == number)
                return true;
            else if (array[mid] < number)
                start = mid + 1;
            else
                end = mid -1;

        }

        return false;
    }

    /**
     * Exponential | O(2^n)
     * An algorithm is said to have an exponential time if its runtime
     * doubles with each addition to the input data set. It starts off very shallow,
     * then rises meteorically. A recursive calculation of Fibonacci number is one example.
     *
     */

    public int fibonacciExample(int number) {
        if (number <= 1) return number;

        return fibonacciExample(number -2) + fibonacciExample(number - 1);
    }

    public static void main(String args[]) {
        BigONotationsExamples examples = new BigONotationsExamples();

        //************************Big O(1)********************************
        System.out.println("Constant Examples:");
        System.out.println(examples.constantExample(examples.names));
        System.out.println(examples.constantExample(examples.numbers));
        System.out.print("\n");
        //****************************************************************

        //************************Big O(n)********************************
        System.out.println("Linear Examples:");
        System.out.println(examples.linearExample("Catharine", examples.names)); // It is linear O(n)
        System.out.println(examples.linearExample("John", examples.names)); // It is not linear

        System.out.println(examples.linearExample(9, examples.numbers)); // It is
        System.out.println(examples.linearExample(4, examples.numbers)); // It isn't
        System.out.print("\n");
        //****************************************************************

        //************************Big O(n^2)********************************
        examples.quadraticExample(examples.names);
        examples.quadraticExample(examples.numbers);
        System.out.print("\n");
        //****************************************************************

        //************************Big O(log n)********************************
        System.out.println(examples.logarithmic(2, examples.numbers));
        System.out.print("\n");
        //****************************************************************

        //************************Big O(2^n)********************************
        System.out.println(examples.fibonacciExample(8));
        System.out.print("\n");
        //****************************************************************
    }

}
