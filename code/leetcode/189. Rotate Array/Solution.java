// circular swap. O(1) space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int start = 0, curr = nums[0], prev = 0;
        int index = 0;
        /**
        place 1 -> 5
        prev = curr = 1
        index = (index + k) % n
        curr = nums[index] = 5
        
        nums[index] = prev
        
        
        prev = curr = 5
        index = 
        1, 2, 3, 4, 5, 6, 7
        1, 2, 3, 4, 1, 6, 7
        
        */
        
        for (int count = 0; count < n; count++){
            
            // store for next use
            prev = curr;
            index = (index + k) % n;
            
            // store for next use
            curr = nums[index];
            nums[index] = prev;
            if (index == start){
                index = (++start) % n;
                curr = nums[index];
            }
        }
    }
}
