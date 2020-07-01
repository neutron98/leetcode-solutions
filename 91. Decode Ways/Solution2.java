// O(n), O(1)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int curWays = 1;
        int preWays = 1;
        int length = s.length();
        
        for(int i = 1; i < length; i++){
            int newCurWays = curWays;
            if(s.charAt(i) == '0'){// ends with zero
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2'){ // 10 or 20
                    newCurWays = preWays; 
                } else{
                    return 0; // 100, 170, 1701, return 0 no matter how many prev ways
                }
                 
            }else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')){ 
                // else if 10~27
                newCurWays += preWays;
            }
            preWays = curWays;
            curWays = newCurWays;
        }
        return curWays;
    }
}
