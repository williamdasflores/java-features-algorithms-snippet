package algorithms.insertion_sort;

import java.util.List;

/**
 * Insertion sort works best when the input is mostly sorted. A good
 * application for this is inserting a new element into an already sorted.
 * The worst-case scenario for it is the input array in
 * reverse-sorted order[9,5,4,3,2,1].
 * In terms of big-O notation, the worst-case is O(n^2) and the
 * best case is O(n). As we take the worst-case result though,
 * the algorithm as a whole is O(n^2).
 */
public class InsertionSort {

    public void sort(List<Integer> numbers) {
        List<Integer> sorted = sorting(numbers);
        printList(sorted);
    }

    private List<Integer> sorting(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            int index = i;
            int minimum = i - 1;

            while (minimum >= 0) {
                if (numbers.get(minimum) > numbers.get(index)) {
                    int aux = numbers.get(minimum);
                    numbers.set(minimum, numbers.get(index));
                    numbers.set(index, aux);
                }
                minimum--;
                index--;
            }
        }

        return numbers;
    }

    private void printList(List<Integer> numbers) {
        numbers.stream().sorted();
        numbers.stream().forEach(number -> System.out.print(number + " "));
    }
}
