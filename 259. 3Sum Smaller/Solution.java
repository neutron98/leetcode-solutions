// Time: O(n^2) + O(nlogn)
// Space: O(1)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int currSum = nums[i] + nums[l] + nums[r];
                int diff = target - currSum;
                if (diff > 0){
                    count += r - l; // 重点！
                    l++;
                } else{
                    r--;
                }
            }
        }
        
        return count;
    }
}
