// Greedy: O(n), O(1)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int globalMax = 1;
        int localMax = 1;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i-1]){
                localMax++;
                globalMax = Math.max(globalMax, localMax); // update globalMax
            } else{ // else, reset localMax
                localMax = 1;
            }
        }
        return globalMax;
    }
}
