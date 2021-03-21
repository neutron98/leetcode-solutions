// bit manipulation

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // nums = [1,2,3]
        // 1: selected, 0: not selected
        // 000 -> []
        // 100 -> [1]
        // 110 -> [1, 2]
        // 010 -> [2]
        // 111 -> 2^n - 1 == 1<< n - 1
        int n = nums.length;
        for (int s = 0; s < (1<< n); s++){
            List<Integer> subset = new ArrayList<>();
            // s is the current bit pattern
            // if the ith bit(from right to left) is 1, 
            // then the corresponding element in the array is selected
            for (int i = 0; i < n; i++){
                if (((s >> i) & 1) == 1){
                    subset.add(nums[i]);
                }
            }
            
            results.add(subset);
        }
        
        return results;
    }
}
