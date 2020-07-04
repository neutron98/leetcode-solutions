//空间优化到O(1)
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
        // equals f[i-1], f[i-2]
        int w1 = nums[0];    //f[1]
        int w2 = 0;  //f[0]   
        
        for (int i = 2; i <= n; i++){
            //f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]);
            int w = Math.max(w1, w2 + nums[i-1]);
            w2 = w1;
            w1 = w;
        }
        return w1;
    }
}
