class Solution {
    /***
            []
        [1]     [2]
    [1, 2]
[1, 2, 2]
    
    
    ***/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    /***
    Traverse the nums array, constructs subset, and add subset to results.
    @param nums
    @param start    The start index of the element being added to a subset.
    @param subset
    @param results
    ***/
    private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++){
            // skip duplicate. only add the first element
            if (i != start && nums[i] == nums[i-1]){
                continue;
            }
            if (i == nums.length){
                return;
            }
            // add current element to subset
            subset.add(nums[i]);
            // continue to next element
            dfs(nums, i + 1, subset, results);
            // backtrack
            subset.remove(subset.size() - 1);
        }
    }
}
