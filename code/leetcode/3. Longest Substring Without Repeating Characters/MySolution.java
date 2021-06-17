class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        Sliding window
        
        need information: if a char apeared before? last appeared position?
        HashMap<char, index of last pos>
        
        a b c a b c b b
        l
              r
              
        b a c a b c b b
            l
              r
        
        
        algo:
        
        l = 0, r = 0
        
        while r < s.length():
            if map does not contain rightChar| rightChar pos < l:
                put rightChar, r into map
                update maxLen
            else:
                l = lastPos + 1
                
                put rightChar, r into map
        return maxLen
        **/
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r;
        for (r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            if (!map.containsKey(rightChar) || map.get(rightChar) < l){
                map.put(rightChar, r);
                maxLen = Math.max(maxLen, r - l + 1);
            } else{
                l = map.get(rightChar) + 1;
                map.put(rightChar, r);
            }
        }
        
        return maxLen;
    }
}
