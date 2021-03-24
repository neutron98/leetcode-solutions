public class Solution {
    // O(MN)
    // O(MN)
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        
        
        /* dp[i][j]: whether first (i+j) chars can be formed by the
         interleaving of s1[0:i-1](first i chars) and s2[0:j-1](first j chars)
 
        已知前一个状态：
        X X X
        Y Y Y Y Y
        
        Z Z Z Z Z Z Z Z
        
        s3的这八个字母是由s1 s2组成的
 
        那么s3想再加一个字母，这个字母肯定来自s1[i]或者s2[j]
        X X X i
        Y Y Y Y Y j
        
        Z Z Z Z Z Z Z Z ?
        
        两种情况：
        (1) Z的最后一个字母来自i
        X X X {i}
        Y Y Y Y Y j
        
        Z Z Z Z Z Z Z Z {i}
        
        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)


        (2) Z的最后一个字母来自j
        X X X i
        Y Y Y Y Y {j}
        
        Z Z Z Z Z Z Z Z {j}
        
        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)


        */ 
        boolean dp[][] = new boolean[m + 1][n + 1];
        // init
        dp[0][0] = true;
        
        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for (int j = 1; j <= n; j++){
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = true;
                } else if(dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
