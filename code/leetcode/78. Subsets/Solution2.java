// backtraking
// O(N * 2 ^ N), O(N * 2 ^ N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(nums, 0, results, new ArrayList<>());
        return results;
    }
    
    private void helper(int[] nums, int start, List<List<Integer>> results,
                       List<Integer> subset){
        results.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            helper(nums, i + 1, results, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
