// O(N), O(K)

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> charFreq = new HashMap<>();

        int maxLen = 0;
        int numDist = 0;  // current number of distinct 
        int l = 0;
        int r;

        for (r = 0; r < s.length(); r++){
          char rightChar = s.charAt(r);
          charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
          // when shrinking the window, we do two things:
          // 1. increase l
          // 2. decrease charFreq of the previous character of l
          // when the character at l has a frequency of 0, we know the number of distinct chars is 
          // decreased by 1, and thus we can remove the key
          while (charFreq.size() > k){
            char leftChar = s.charAt(l);
            charFreq.put(leftChar, charFreq.get(leftChar) - 1); 
            if (charFreq.get(leftChar) == 0){
              charFreq.remove(leftChar); 
            }
            l++;  
          }
          maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
