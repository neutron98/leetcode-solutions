class Solution {
    // dp
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp[i]: satisfy for first i letters
        // dp[j] = true if dp[i] == true and su
        
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
