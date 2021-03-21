public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // last number put or not put
        // 2. transition function 
        // f[i] = f[i-m1] + f[i-m2] + f[i-m3]
        
        // 3. init and edges
        // f[0] = 1
        
        // 4. order and answer 
        // f[target]
        
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[] f = new int[target+1];
        f[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int num: nums){
                if (i >= num){
                    f[i] += f[i-num];
                }
            }
        }
        return f[target];
    }
}
