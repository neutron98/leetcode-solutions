// O(n), O(n)
//什么时候必须用n+1?
class Solution {
    public int rob(int[] nums) {
        
        // f[i] 偷i个房子，并且i-1偷
        
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        
        if (n == 1){
            return nums[0];
        }
        
        
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = nums[0];
        
        for (int i = 2; i <= n; i++){
            f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]);
        }
        return f[n];
    }
}
