// O(n^2), O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        // 1.
        // if 当前字符串是palin, 即s[i] == s[j], 那么s[i+1]...s[j-1]也是palin
        // else, 要么去掉头要么去掉尾, s[i+1]...s[j] 和s[i]...s[j-1]里面找
        
        // 2. transition function
        // f[i][j] = max{f[i+1][j], f[i][j-1], f[i+1][j-1] + 2 (when s[i] == s[j])}
        
        
        // 3. init and edges
        // f[0][0] = f[1][1] = ... = f[n-1][n-1] = 1
        // 一个字母也是长度为1的palin
        // edge:
        // if s[i] == s[i+1], f[i][i+1] = 2, else, f[i][i+1] = 1
        
        // * 4. order: 
        // length (j-i): small to large
        
        if (s == null || s.length() == 0){
            return 0;
        }
        
        char[] arr = s.toCharArray();
        
        int n = arr.length;
        if (n == 1){
            return 1;
        }
        
        int[][] f = new int[n][n];
        
        // len 1
        for (int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        
        // len 2
        for (int i = 0; i < n - 1; i++){
            f[i][i+1] = (arr[i] == arr[i+1]) ? 2 : 1;
        }
        
        for (int len = 3; len <= n; len++){
            for (int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                f[i][j] = Math.max(f[i+1][j], f[i][j-1]);
                if (arr[i] == arr[j]){
                    f[i][j] = Math.max(f[i][j], f[i+1][j-1] + 2);
                }
            }
        }
        
        return f[0][n - 1];
    }
}
