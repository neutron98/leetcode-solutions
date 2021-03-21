class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0, r;
        int maxLen = 0;
        Map<Character, Integer> lastOccur = new HashMap<>();

        for (r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            if (lastOccur.containsKey(rightChar)){  // c c a b c
              // start new window
              l = Math.max(l, lastOccur.get(rightChar) + 1);
            }
            lastOccur.put(rightChar, r); // insert the 'rightChar' into the map
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
