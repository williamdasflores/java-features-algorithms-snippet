package algorithms.insertion_sort;

import java.util.Arrays;

public class RunApplication {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(Arrays.asList(4,5,3,2,1,10,9));
    }
}
