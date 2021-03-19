// DFS + memo
public class Solution {
    
    Boolean[] validCutFrom;

    
    public boolean wordBreak(String s, List<String> wordDict) {
        validCutFrom = new Boolean[s.length()];
        
        return wordBreakMemo(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        
        if (validCutFrom[start] != null){
            return validCutFrom[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end)) {
                validCutFrom[start] = true;
                return true;
            }
        }
        validCutFrom[start] = false;
        return false;
    }
}
