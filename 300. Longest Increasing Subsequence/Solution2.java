class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> dp = new ArrayList<>();
        for (int num: nums){
            int i = search(dp, num);
            if (i == dp.size()){
                dp.add(num);
            } else{
                dp.set(i, num);
            }
            
        }
        
        return dp.size();
        
    }
    
    private int search(List<Integer> dp, int x){
        int start = 0, end = dp.size() - 1;
        
        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if (x == dp.get(mid)){
                end = mid;
            } else if (x < dp.get(mid)){
                end = mid;
            } else{
                start = mid;
            }
        }
        
        if (dp.size() == 0){
            return 0;
        }
        
        if (x <= dp.get(start)){
            return start;
        }
        if (x <= dp.get(end)){
            return end;
        }
        return dp.size();
    }
}
