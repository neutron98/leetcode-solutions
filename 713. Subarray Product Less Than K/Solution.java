class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){
            return 0;
        }
        int count = 0;
        int product = 1;
        int l = 0, r;
        // window     count
        // [10]        +1
        // [10, 5]     +2 ([5] and [10, 5])
        // [10, 5, 2]  n
        // [5, 2]      +2 ([2] and [5, 2]) 
        // [5, 2, 6]   +3 ([6], [2, 5], and [5, 2, 6])
        for (r = 0; r < nums.length; r++){
            product *= nums[r];
            while (product >= k && l <= r){ // 注意这个！
                product /= nums[l++];
            }
            count += r - l + 1;
        }
        
        return count;
    }
}
