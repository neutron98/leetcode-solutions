class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < nums.length - 1 && nums[l] <= nums[l + 1]){
            l++;
        }
        if (l == nums.length - 1){
            return 0;
        }
        
        while (r > 0 && nums[r] >= nums[r - 1]){
            r--;
        }
        
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++){
            subarrayMax = Math.max(subarrayMax, nums[i]);
            subarrayMin = Math.min(subarrayMin, nums[i]);
        }
        
        while (l > 0 && nums[l-1] > subarrayMin){
            l--;
        }
        while (r < nums.length - 1 && nums[r + 1] < subarrayMax){
            r++;
        }
        
        return r - l + 1;
    }
}
