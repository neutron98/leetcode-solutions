class Solution {
    public void moveZeroes(int[] nums) {
        // [0,1,0,3,12]
        // [1,0,0,3,12]
        
        int l = 0; // last index of non-zero element
        int r = 0; // current cursor
        while (r < nums.length){
            if (nums[r] != 0){
                swap(nums, l, r);
                l++;
            }
            r++;
        }
        
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
