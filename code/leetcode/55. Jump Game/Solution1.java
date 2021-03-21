// DP
// Time complexity: O(N^2), Space: O(N)
// Sub-optimal

class Solution {
    public boolean canJump(int[] nums) {
        // 1. Last step: 
        // if can jump to n-1 from i
        // 2 criteria;
        // (1) can jump to i
        // (2) distance does not exceed maximum: (n-1)-i <= a_i
        
        
        // 2. Transfer function
        // for i from 0~j
        // f[j] = OR (f[i] && (nums[i]>=j-i))
        
        
        // 3. Initial step and edge cases
        // f[0] = true
        // No edge cases
        
        
        // 4. Order
        
        
        int n = nums.length;
        boolean[] f = new boolean[n];
        
        f[0] = true;
        
        for (int j = 0; j < n; j++){
            // current stone j
            for (int i = 0; i < j; i++){
                // prev stone i
                // last jump is from i to j
                if (f[i] && nums[i] >= j - i){
                    f[j] = true;
                    break;
                }
            }
        }
        
        return f[n-1];
    }
}
