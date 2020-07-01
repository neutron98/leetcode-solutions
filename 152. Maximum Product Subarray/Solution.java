class Solution {
    // Time: O(N), Space: O(1)
    public int maxProduct(int[] nums) {
        // 1. last step
        // last element is a[j]. 
        // (1) a[j]
        // (2) prev: a[j-1]
        //        a[j] > 0. {.. a[j-1]} has the max product
        //        a[j] < 0. {.. a[j-1]} has the min product
        
        // 2. transition function
        
        // f[x] : max product of subarray ending with a[x]
        // g[x] : min product of subarray ending with a[x]
        
        // f[i] = max{a[i], f[i-1]*a[i], g[i-1]*a[i]}
        // g[i] = min{a[i], f[i-1]*a[i], g[i-1]*a[i]}
        
        // 3. initial state and edge cases
        // f[0] = g[0] = a[0]
        // j>0
        
        // 4. order: left-right
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        
        int maxProduct = nums[0];
        
        f[0] = nums[0]; 
        g[0] = nums[0];
        
        for (int i = 1; i < n; i++){
            if (nums[i] > 0){
                f[i] = Math.max(nums[i], f[i-1] * nums[i]);
                g[i] = Math.min(nums[i], g[i-1] * nums[i]);
            } else{
                f[i] = Math.max(nums[i], g[i-1] * nums[i]);
                g[i] = Math.min(nums[i], f[i-1] * nums[i]);
            }
            
            maxProduct = Math.max(maxProduct, f[i]);
        }
        
        return maxProduct;
        
    }
}
