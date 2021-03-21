// O(n^2), O(n)
// can be optimized
class Solution {
    public int lengthOfLIS(int[] nums) {
        // last step:
        // (1) {a[j]}
        // (2) ends with a[j]
        
        // prev is a[i], and a[i] < a[j]
        
        // 2. transition function
        // f[j] = Max{1, f[i] + 1}, a[i] < a[j]
        if (nums == null || nums.length == 0){
            return 0;
        }
        // 3. f[0] = 1
        int n = nums.length;
        int res = 1;
        int[] f = new int[n];
        for (int j = 0; j < n; j++){
            f[j] = 1;
            for (int i = 0; i < j; i++){
                if (nums[i] < nums[j]){
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            res = Math.max(res, f[j]);
        }
        
        return res;
        
    }
}
