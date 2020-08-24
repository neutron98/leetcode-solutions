// Space optimized to O(n)
class Solution {
    public boolean stoneGame(int[] piles) {
        // sum: A, B
        // obj: A-B>0
        // 2. transition function
        // f[i]: diff for current player facing current piles i ~ i + l - 1 (j)
        // f[i] = m - f[i_1]
        // f[i][j] = max{piles[i] - f[i+1], piles[i+l-1] - f[i]}
        
        // 3. init and edges
        
        // 4. order and ans
        // len from 2 to n
        // ans: f[0]
        
        int n = piles.length;
        int[] f = new int[n];
        
        int len, i, j;
        for (len = 2; len <= n; len++){
            for (i = 0; i <= n - len; i++){
                f[i]= Math.max(piles[i] - f[i+1], piles[i+len-1] - f[i]);
            }
        }
        
        return f[0] > 0;
    }
}
