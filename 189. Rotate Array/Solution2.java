// 类似于reverse words in string
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        /**
        Original List                   : 1 2 3 4 5 6 7
        After reversing all numbers     : 7 6 5 4 3 2 1
        After reversing first k numbers : 5 6 7 4 3 2 1
        After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
        */
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        
    }
    
    private void reverse(int[] nums, int start, int end){
        int l = start, r = end;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
