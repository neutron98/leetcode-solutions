// Greedy: Time: O(n), Space: O(1)


class Solution {
    public boolean canJump(int[] nums) {
        // We don't care how many steps we have
        // We only care the farthest point we can reach
        // Use a variable [reach] to record this index
        // When unreachable or at the last position, break; otherwise, update [reach].
        
        int reach = 0, n = nums.length;
        
        for (int i = 0; i < n; i++){
            if (i > reach || reach >= n-1){
                break;
            } else{
                reach = Math.max(reach, i+nums[i]);
            }
        }
        
        return (reach >= n-1);
    }
}
