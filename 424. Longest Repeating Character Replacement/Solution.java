class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r;
        int maxRepeatCount = 0;
        int maxLen = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (r = 0; r < s.length(); r++){
          char rightChar = s.charAt(r);
          charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
          maxRepeatCount = Math.max(maxRepeatCount, charFreq.get(rightChar));

          // when do we stop increasing window size / shrinking window?
          //  - when the window size - maxRepeatCount > k
          // because this means we cannot replace all other characters in the window to make them consecutive
          while (r - l + 1 - maxRepeatCount > k){
            char leftChar = s.charAt(l);
            charFreq.put(leftChar, charFreq.get(leftChar) - 1);
            l++;
          }
          maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
     }
}
