// Recursion with Memorization
class Solution {
    // 记忆化搜索
    int[][] f = null;
    char[] arr = null;
    int n = 0;
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        arr = s.toCharArray();
        n = arr.length;
        if (n == 1){
            return 1;
        }
        
        f = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                f[i][j] = -1; // not computed yet
            }
        }
        
        compute(0, n - 1);
        return f[0][n - 1];
    }
    
    private void compute(int i, int j){
        if (f[i][j] != -1){  // already computed
            return;
        }
        
        if (i == j){
            f[i][j] = 1;
            return;
        }
        
        if (i + 1 == j){
            f[i][j] = (arr[i] == arr[j]) ? 2 : 1;
            return;
        }
        
        // recursion
        compute(i + 1, j);
        compute(i, j - 1);
        compute(i + 1, j - 1);
        // DP
        f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
        if (arr[i] == arr[j]){
            f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
        }
    }
}
