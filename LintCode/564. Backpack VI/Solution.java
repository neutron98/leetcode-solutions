public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        
        int n = nums.length;
        int[] f = new int[target+1];
        f[0] = 1;
        for (int i = 1; i <= target; i++){
            f[i] = 0;
            for (int j = 0; j < n; j++){
                if (i >= nums[j]){
                    f[i] += f[i-nums[j]];
                }
            }
        }
        
        return f[target];
    }
}
