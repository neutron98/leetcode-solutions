// Greedy
// O(n), O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        
        int currMax = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            globalMax = Math.max(globalMax, currMax);
        }
        
        return globalMax;
    }
}
