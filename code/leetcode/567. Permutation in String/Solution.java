
// Time： O(l1 + (l2 - l1))  比用两个map更好
// 第一个循环是O(l1),第二个是 (l2 - l1)，因为我们的window长度最多是l1
// Space: O(26) = O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }
        
      int matched = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s1.toCharArray())
          freq.put(c, freq.getOrDefault(c, 0) + 1);

        // our goal is to match all the characters from the 'freq' with the current window
        // try to extend the range [windowStart, windowEnd]
        int l = 0, r;
        for (r = 0; r < s2.length(); r++) {
          char rightChar = s2.charAt(r);
          if (freq.containsKey(rightChar)) {
            // decrement the frequency of the matched character
            freq.put(rightChar, freq.get(rightChar) - 1);
            if (freq.get(rightChar) == 0) // character is completely matched
              matched++;
          }

          if (matched == freq.size())
            return true;
// when the window length already matches s1 length, and still not match, we should not increase r anymore
          if (r - l + 1 >= s1.length()) { 
            char leftChar = s2.charAt(l);
            if (freq.containsKey(leftChar)) {
              if (freq.get(leftChar) == 0)
                matched--; // before putting the character back, decrement the matched count
              // put the character back for matching
              freq.put(leftChar, freq.get(leftChar) + 1);
            }
            l++;
          }
        }

        return false;
    }
}
