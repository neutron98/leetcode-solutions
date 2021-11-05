class Solution {
    /***
    https://www.youtube.com/watch?v=_MJKUvM-4fM
    
    Time: O(26*N)
    Space: O(26*N)
    
    k = 2
    
    a   b   c   b   a   b   a   b  
    l               r
    
    minFreqInWindow should >= k
    
    maintain a sliding window, has exactly {m} number of distinct characters. where m is from 1 to 26
    for each m, l = 0, r = 0:
        while distinct character <= m
            increase r pointer, update frequency map. when freq reaches k, update validCount
            
            if distinct character == m && validCount == m:
                update length
        r--
        
        while distinct character > m:
            move l
            update distinctCount and validCount
        
        move r
    ***/
    int maxLen = 0;
    public int longestSubstring(String s, int k) {
        int windowMinFreq ;
        for (int m = 1; m <= 26; m++){
            longestSubstring(s, m, k);
        }
        return maxLen;
    }
    
    private void longestSubstring(String s, int m, int k){
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0, r;
        int validCount = 0; // number of distinct chacters that freq >= k
        for (r = 0; r < s.length(); r++){
            while (r < s.length() && freqMap.size() <= m){
                char rightChar = s.charAt(r);
                freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
                if (freqMap.get(rightChar) == k){
                    validCount++;
                }
                
                if (freqMap.size() == m && validCount == m){
                    maxLen = Math.max(maxLen, r - l + 1);
                }
                r++;
            }
            r--;
            
            while (freqMap.size() > m){
                char leftChar = s.charAt(l);
                if (freqMap.get(leftChar) == k){
                    validCount--;
                }
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0){
                    freqMap.remove(leftChar);
                }
                l++;
            }
        }
    }
    
}
