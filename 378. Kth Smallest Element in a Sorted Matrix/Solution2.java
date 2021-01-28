// O(logX) iterations of binary search, X = matirx[n-1][n-1] - matrix[0][0]
// each iteration takes O(N) for counting

// time: O(N * logX)
// space: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        int count;
        while (start < end){
            int mid = (end - start) / 2 + start;
            count = countSmallerOrEqual(matrix, mid);
            if (k == count){
                end = mid;
            } else if(count < k){
                start = mid + 1;
            } else{ // count > k
                end = mid;
            }
        }
        // return untill start & end is equal
        // in this case, just return any of them
        return start;
    }
    
    private int countSmallerOrEqual(int[][] matrix, int target){
        int n = matrix.length;
        int count = 0;
        int i = 0, j = n - 1;   // start from top right
        while (i < n && j >= 0){
            // if this value <= target
            if (matrix[i][j] <= target){
                // then j+1 numbers in this row <= target
                count += j + 1;
                // go to next row
                i++;
            } else{
                j--;
            }
        }
        return count;
        
    }
}
