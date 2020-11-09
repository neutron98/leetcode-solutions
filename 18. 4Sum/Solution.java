class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int searchSum = target - (nums[i] + nums[j]);
                twoSum(i, j, searchSum, nums, results);
            }
        }
        return results;
    }
    
    private void twoSum(int firstIndex, int secondIndex, int target, int[] nums, List<List<Integer>> results){
        
        int l = secondIndex + 1, r = nums.length - 1;
        while (l < r){
            if (nums[l] + nums[r] == target){
                results.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[l], nums[r]));
                l++;
                r--;
                // skip duplicates
                while (l < r && nums[l] == nums[l-1]){
                    l++;
                }
                while (l < r && nums[r] == nums[r+1]){
                    r--;
                }
            } else if (nums[l] + nums[r] < target){
                l++;
            }  else{
                r--;
            }
            
        }
    }
}
