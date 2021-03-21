// O(n)
// O(1)
class Solution {
    public void sortColors(int[] nums) {
        // l: last 0, r: last 1. i: curr element
        int n = nums.length;
        if (n == 1){
            return;
        }
        int l = 0, r = n - 1;
        int i = 0;
        
       while (i <= r){
            if (nums[i] == 0){
                swap(nums, l, i);
                l++;
                i++;
            } else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
            } else{
                i++;
            }

        }
    }   
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
