class Solution {
    public boolean stoneGame(int[] piles) {
        
        // 1.
        // assume Alex has A, Lee has B
        // objective: A > B
        // A - B > 0
        
        // 当一方X面对剩下的数字，可以认为X就是当前的先手，他的目标就是最大化
        // S[x] = X - Y
        
        // 当他取走m后，对手Y变成先手，同理他也要最大化S[y] = Y - X
        
        // 对于X来说， S[x] = -S[y] + m
        // m有两个可能的值，选第一个m1或者最后一个m2。目标是最大化S[x]
        
        // 区间型动态规划
        
        // 2. transition function
        // f[i][j]: current person facing a[i]...a[j], 
        // max difference he can get
        // f[i][j] = max{a[i] - f[i + 1][j], a[j] - f[i][j - 1]}
        
        // 3. init and edge
        // one stone: this person get a[i], another get 0. diff = a[i]
        // f[i][i] = a[i], i = 0...n-1
        
        // 4. order and answer
        // length: 1 to n
        
        // if f[0][n-1] >= 0, Alice win
        
        int n = piles.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++){
            f[i][i] = piles[i];
        }
        
        
        for (int len = 2; len <= n; len ++){
            for (int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] >= 0;
        
        
    }
}
