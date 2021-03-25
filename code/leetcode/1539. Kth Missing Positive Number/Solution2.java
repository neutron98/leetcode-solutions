class Solution {
    public int findKthPositive(int[] arr, int k) {
        // https://www.youtube.com/watch?v=2B1jieoZKus
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (end - start) / 2 + start;
            // [2,3,4,7,11]
            int missing = arr[mid] - 1 - mid; // num of missing positives that < arr[mid]
            
            if (missing < k){
                start = mid + 1;
            } else if(missing > k){
                end = mid - 1;
            } else{
                end = mid - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = end + k + 1
        return end + k + 1;
    }
}
