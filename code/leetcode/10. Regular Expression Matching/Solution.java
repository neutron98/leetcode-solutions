// O(MN)
// O(MN)

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        /*
        * init: when s is empty
        * s: ""
        * p: "a*
        */
        for (int j = 1; j <= n; j++){
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]){
                dp[0][j] = true;
            }
        }
        
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                // same letter or '.'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*'){
                    /*
                    * Different letter
                    * s: "a"
                    * p: "b*
                    */
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        // treat "b*" as a empty string
                        dp[i][j] = dp[i][j - 2];
                    } else {// same letter:
                            // the letter 'b' can have 3 cases:
                            // case 1: no letter; case 2: one letter; case 3: many letters

                            /**
                            * case 1: no letter. depends on string before the letter
                            * s: ""
                            * p: "a*"
                            * case 2: one letter
                            * s: "a"
                            * p: "a*"
                            * case 3: many letters. adding one letter in s has no effect
                            * s: "aaaa"
                            * p: "a*"
                            */
                            dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                        }
                    }
            }
        }
        return dp[m][n];
    }
}
