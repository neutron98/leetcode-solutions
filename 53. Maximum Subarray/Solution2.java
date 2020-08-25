// Divide and conquer
// O(nlogn), O(logn)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return maxSumBetween(nums, 0, nums.length - 1);
    }
    
    private int maxSumBetween(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        
        int mid = (left + right) / 2;
        int leftMax = maxSumBetween(nums, left, mid);
        int rightMax = maxSumBetween(nums, mid + 1, right);
        int crossMax = crossSumBetween(nums, left, right);
        return Math.max(leftMax, Math.max(crossMax, rightMax));
    }
    
    private int crossSumBetween(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        
        int mid = (left + right) / 2;
        
        int leftSum = Integer.MIN_VALUE;
        int currSum =0;
        for (int i = mid; i >= left; i--){
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = mid + 1; i < right + 1; i++){
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        return leftSum + rightSum;
    }
}
