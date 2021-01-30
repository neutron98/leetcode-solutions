
public class MergeSort {

    /**
     * merge sort method.
     * @param from input array to sort
     */
    public static void mergeSort(int[] from) {
        // create a new array
        int[] to = new int[from.length];
        mergeSort(from, to, 0, from.length - 1);
    }

    /**
     * helper method to merge sort from (input) array using an auxiliary array.
     * @param from input array to sort
     * @param to auxiliary array to use
     * @param left left boundary
     * @param right right boundary
     */
    private static void mergeSort(int[] from, int[] to, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        // recursive case
        // find midpoint
        int mid = left + (right - left) / 2;
        // sort left half recursively
        mergeSort(from, to, left, mid);
        // sort right half recursively
        mergeSort(from, to, mid + 1, right);
        // merge them
        merge(from, to, left, mid + 1, right);
    }

    /**
     * Instead of creating multiple arrays, this merge works with only two arrays.
     * @param from input array
     * @param to auxiliary array to use during merge process
     * @param leftPos starting point of left half
     * @param rightPos starting point of right half
     * @param rightBound upper bound of right half
     */
    public static void merge(int[] from, int[] to, int leftPos, int rightPos, int rightBound) {
        // upper bound of left half
        int leftBound = rightPos - 1;
        // index of to array, starting point of left half
        int toIndex = leftPos;
        // total number of items to examine
        int numOfItems = rightBound - leftPos + 1;
        while (leftPos <= leftBound && rightPos <= rightBound) {
            if (from[leftPos] <= from[rightPos]) {
                to[toIndex++] = from[leftPos++];
            } else {
                to[toIndex++] = from[rightPos++];
            }
        }

        //Copy rest of left half
        while (leftPos <= leftBound) {
            to[toIndex++] = from[leftPos++];
        }

        // Copy rest of right half
        while (rightPos <= rightBound) {
            to[toIndex++] = from[rightPos++];
        }


        //Post process that needs to be done
        for (int i = 0; i < numOfItems; i++, rightBound--) {
            from[rightBound] = to[rightBound];
        }
    }



}
