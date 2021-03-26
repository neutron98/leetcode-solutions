1. Subsets 

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        helper(0, nums, new ArrayList<>(), results);
        return results;
    }
    
    private void helper(int start, int[] nums, List<Integer> subset,
                        List<List<Integer>> results){
        
        results.add(new ArrayList<Integer>(subset));
        
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            helper(i + 1, nums, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
```


2. Permutations
