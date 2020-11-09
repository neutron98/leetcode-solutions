// Time: O(n^2 + nlogn)
// Space: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int currDiff = target - (nums[i] + nums[l] + nums[r]); // avoid overflow
                if (currDiff == 0){
                    return target;
                }

                if (Math.abs(currDiff) < Math.abs(minDiff)){
                    minDiff = currDiff;
                }

                if (currDiff > 0){
                    l++;
                } else{
                    r--;
                }
            }
        }
        return target - minDiff;
    }
}
