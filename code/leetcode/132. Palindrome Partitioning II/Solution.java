// O(n^2), O(n^2)
class Solution {
    public int minCut(String s) {
        // f[i]: 前i个可以多少个回文串
        // f[i] = f[j] + 1 (S[j..i-1]) is a palindrome
        
        // 如何判断回文串？
        // 直接判断需要O(n^3)：找i -> n, 找j -> n，i到j -> n
        // 回文串分两种：长度奇数/长度偶数
        // 现在不是找回文串，而是生成回文串
        // 以字符串的每一个字符为中点/中心线，向两边扩展
        // 奇数：n个中心，偶数：n-1个对称轴。最多扩展n/2次
        // 这样就控制在了O(n^2)
        
        // f[i] = min{f[j] + 1 | isPalin[j][i-1] = True}
        
        // 答案是f[n] - 1
        
        int n = s.length();
        if (n == 0){
            return 0;
        }
        
        char[] arr = s.toCharArray();
        
        boolean[][] isPalin = calcPalin(arr);
        int[] f = new int[n+1];
        f[0] = 0;
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
    
    public boolean[][] calcPalin(char[] s){
        int n = s.length;
        boolean[][] f = new boolean[n][n];  // by default: false
        
        int i, j, c;
        // odd length
        for (c = 0; c < n; c++){
            i = j = c; // initial:
            while (i >= 0 && j < n && s[i] == s[j]){
                // is palindrome
                f[i][j] = true;
                // extend
                i--;
                j++;
                
            }
        }
        // even length
        for (c = 0; c < n - 1; c++){
            i = c; 
            j = c + 1;
            while (i >= 0 && j < n && s[i] == s[j]){
                // is palindrome
                f[i][j] = true;
                // extend
                i--;
                j++;
                
            }
        }
        
        return f;
    }
}
