package quickSort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSortExample {

    static int[] quickSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        //pivot is the most crucial concept of quick sort!
        int pivot = arr[0];
        int[] smaller = IntStream.range(1, arr.length)
                .filter(i -> arr[i] <= pivot)
                .map(i -> arr[i])
                .toArray();

        int[] larger = IntStream.range(1, arr.length)
                .filter(i -> arr[i] > pivot)
                .map(i -> arr[i])
                .toArray();

        int[] sortSmaller = quickSort(smaller);
        int[] sortLarger = quickSort(larger);

        return IntStream.concat(Arrays.stream(sortSmaller), IntStream.concat(IntStream.of(pivot), Arrays.stream(sortLarger))).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {9,4,1,6,7,3,8,2,5};

        System.out.println(Arrays.toString(quickSort(arr)));
    }
}
