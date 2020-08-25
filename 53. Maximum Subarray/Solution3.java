
// DP
// O(n)
// O(n) -> O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        // f[i]: max sum of subarray up to i
        // f[i] = max{f[i-1] + nums[i], nums[i]}
        
        // 3. init and edges
        // f[0] = nums[0]
        
        // 4. answer: 
        // max{f[i]}
        
        if (nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++){
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
            maxSum = Math.max(f[i], maxSum);
        }
        return maxSum;
    }
}
