// O(l1 + (l2-l1)) = O(l2)
// O(1)

class Solution {
    public String minWindow(String s, String t) {
        int matched = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: t.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int l = 0, r;
        int minLen = Integer.MAX_VALUE;
        int validStart = 0;
        
        for (r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            if (freq.containsKey(rightChar)){
                freq.put(rightChar, freq.getOrDefault(rightChar, 0) - 1);
                if (freq.get(rightChar) == 0){
                    matched++;
                }
            }
            
            while (matched == freq.size()){ // as long as match count equals
                if (r - l + 1 < minLen){ // if we can shrink
                    minLen = r - l + 1;
                    validStart = l;  // try to find a substr in the window. this is a valid position
                }
                
                char leftChar = s.charAt(l++);
                if (freq.containsKey(leftChar)){
                    if (freq.get(leftChar) == 0){
                        matched--;
                    }
                    
                    freq.put(leftChar, freq.get(leftChar) + 1);
                }
            }
        }
        
        if (minLen > s.length()){
            return "";
        } else{
            return s.substring(validStart, validStart + minLen);
        }
    }
}
