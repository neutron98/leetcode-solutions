class Solution {
    public int maxSubArray(int[] nums) {
        // prefix sum
        // f[i] = f[i-1] + nums[i]
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        
        int[] f = new int[n+1];
        
        
        
        for (int i = 1; i <= n; i++){
            f[i] = f[i - 1] + nums[i-1];
        }
        
        int maxDiff = Integer.MIN_VALUE;
        int preMin = 0; // previous min sum
        for (int j = 1; j <= n; j++){
            maxDiff = Math.max(f[j] - preMin, maxDiff);
            preMin = Math.min(preMin, f[j]);
        }
        
        return maxDiff;
    }
}
