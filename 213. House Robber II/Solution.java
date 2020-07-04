class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int robHead = rob(nums, 0, n - 2);
        int robTail = rob(nums, 1, n - 1);
        
        return Math.max(robHead, robTail);
    }
    
    // test cases:
    // [1, 1] -> 1
    // [1, 2]  -> 2
    
    private int rob(int[] nums, int left, int right){
        int w2 = 0; // f[i-2]
        int w1 = nums[left];  // f[i-1]
        for (int i = left + 2; i <= right + 1; i++){
            int w = Math.max(w1, w2 + nums[i-1]);  // f[i], f[i-1], f[i-2]
            w2 = w1;
            w1 = w;
        }
        return w1;
    }
}
