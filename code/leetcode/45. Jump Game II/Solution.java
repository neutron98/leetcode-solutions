class Solution {
    /***
    类似BFS
    
    (A)(BBB)(CCCCC)(DDDDDD)
    
    ***/
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        
        int start = 0, end = 0;
        int step = 0;
        while (start <= end){
            int newEnd = end;
            for (int i = start; i <= end; i++){
                newEnd = Math.max(newEnd, i + nums[i]);
                if (newEnd >= nums.length - 1){
                    return step + 1;
                }
            }
            step++;
            start = end + 1;
            end = newEnd;
        }
        
        return -1;
    }
}
