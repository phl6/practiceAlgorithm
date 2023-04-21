package mergeSort;

import java.util.Arrays;

public class MergeSortPractice {

    static int[] merge(int[] leftArr, int[] rightArr){
        int[] result = new int[leftArr.length + rightArr.length];

        int resultArrIndex = 0;
        int leftArrIndex = 0;
        int rightArrIndex = 0;

        //do sorting with left and right arr
        while(leftArrIndex < leftArr.length && rightArrIndex < rightArr.length){
            result[resultArrIndex++] = leftArr[leftArrIndex] <= rightArr[rightArrIndex] ? leftArr[leftArrIndex++] : rightArr[rightArrIndex++];
        }

        //fill in the rest of the elements
        while(leftArrIndex < leftArr.length){
            result[resultArrIndex++] = leftArr[leftArrIndex++];
        }

        while(rightArrIndex < rightArr.length){
            result[resultArrIndex++] = rightArr[rightArrIndex++];
        }

        return result;
    }

    static int[] mergeSort(int[] arr){
        //base case
        if(arr.length < 2){
            return arr;
        }

        //middle of the arr
        int mid = arr.length / 2;

        //put arr into left and right array
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        //recursion
        return merge(mergeSort(left), mergeSort(right));
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 6, 3, 2, 4};

        System.out.println(Arrays.toString(mergeSort(arr)));

    }

}
