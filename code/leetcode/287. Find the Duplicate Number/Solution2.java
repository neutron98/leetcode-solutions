// One loop

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n){
            // sorted: [1, 2, 3, 3]
            
            // [3, 1, 2, 2]
            if (nums[i] != i + 1){
                if (nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                } else{
                    return nums[i];
                }
            } else{
                i++;
            }
        }
        return -1;
    }
    

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
