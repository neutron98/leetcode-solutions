public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        // f[i][w]: num of ways to make up {w} for first {i} items
        
        // 加法原理： 第i个物品(index i-1) 要么进去要么不进去
        // f[i][w] = f[i-1][w] + f[i-1][w-A[i-1]]
        
        // 3.
        // f[0][0] = 1, f[0][1...M] = 0
        // f[i-1][w-A[i-1]] exist when w-A[i-1] >=0
        
        // 4. ans: f[n][target]
        int n = nums.length;
        int[][] f = new int[n+1][target+1];
        f[0][0] = 1;
        for (int i = 1; i <=n; i++){
            for (int w = 0; w <= target; w++){
                f[i][w] = f[i-1][w];
                if (w >= nums[i-1]){
                    f[i][w] += f[i-1][w-nums[i-1]];
                }
            }
        }
        
        return f[n][target];
    }
}
