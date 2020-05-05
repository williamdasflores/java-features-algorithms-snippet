package algorithms.insertion_sort;

import java.util.Arrays;

public class RunApplication {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(Arrays.asList(1,5,3,2,4,10,9));
    }
}
