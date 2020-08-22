class Solution {
    public int minCut(String s) {
        // f[i]: num of palin for first {i} characters
        // f[i] = min{f[j] + 1} if j~i is a palin, where j ~ [0, i-1]
        // if not found, f[i] = 1
        
        // 3. init and edges
        // f[0] = 0, f[1] = 1
        
        // 4. ans: f[n] - 1
        
        if (s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        boolean[][] isPalin = initPalin(s.toCharArray());
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if (isPalin[j][i-1] && f[j] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[n] - 1;
    }
    
    private boolean[][] initPalin(char[] s){
        int n = s.length;
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++){
            isPalin[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++){
            isPalin[i][i+1] = s[i] == s[i+1] ? true: false;
        }
        int i, j, len;
        for (len = 3; len <= n; len++){
            for (i = 0; i <= n - len; i++){
                j = i + len - 1;
                isPalin[i][j] = (s[i] == s[j] && isPalin[i+1][j-1]);
            }
        }
        return isPalin;
    }
}
