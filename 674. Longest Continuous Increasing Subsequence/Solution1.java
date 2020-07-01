// DP: O(n), O(n)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // test cases:
        // [1, 3, 5, 4, 7]
        
        // [2, 2, 2, 2]
        
        // [1]
        
        // [5, 4, 3, 2, 3]
        // 1. final step
        // two cases:
        // (1) only {a[j]}
        // (2) {... a[j-1], a[j]}
        
        // 2. transition function
        // f[j]: length of max subarray ending with a[j]
        
        // f[j] = max{1, f[j-1] + 1} if a[j] > a[j-1]
        // f[j] = f[j-1] if a[j] <= a[j-1]
        
        
        // 3. initial state and edge cases
        // f[0] = 1
        
        // 4. Computing order: low to high
        
        // answer: max{f[0], f[1]..f[n-1]}
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int res = 1;
        
        int[] f = new int[n];
        f[0] = 1;
        
        for (int i = 1; i < n; i++){
            f[i] = 1;
            if (nums[i] > nums[i-1]){
                f[i] = f[i-1] + 1;
            } 
            
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
