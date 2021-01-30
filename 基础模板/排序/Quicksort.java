package advsort;



import java.util.Random;

public class QuickSortImproved {


    /**
     * Rudimentary (arguably canonical) quick sort algorithm.
     * @param arr array to sort
     */
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive quick sort method.
     * @param arr array to sort
     * @param left left boundary
     * @param right right boundary
     */
    private static void quickSort(int[] arr, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        int pivot = arr[mid];
        int partition = partition(arr, left, right, pivot);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    /**
     * private helper method to partition the array.
     * @param arr array to partition
     * @param left left boundary
     * @param right right boundary
     * @param pivot pivot value (not index)
     * @return the index value where pivot value ends up
     */
    private static int partition(int[] arr, int left, int right, int pivot) {
        int leftPointer = left;
        int rightPointer = right - 1;
        int mid = (right - left) / 2 + left;
        swap(arr, mid, right);
        while(true) {
            while(arr[leftPointer] < pivot) {
                leftPointer++;
            }
            while(rightPointer >= 0 && arr[rightPointer] >= pivot) {
                rightPointer--;
            }
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(arr, leftPointer, rightPointer);
            }

        }
        swap(arr, leftPointer, right);
        return leftPointer;
    }



}
