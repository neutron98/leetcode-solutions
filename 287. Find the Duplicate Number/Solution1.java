// Two loops

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n){
            if (nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            } else{
                i++;
            }
        }
        
        for (i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return nums[i];
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
