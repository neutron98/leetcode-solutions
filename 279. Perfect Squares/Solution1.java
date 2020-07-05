// DP
// O(n^(2/3)), O(n)
class Solution {
    public int numSquares(int n) {
        // 1. sub-problem:
        // n can be divided
        // j - n^j can be divided
        
        // 2. f[i] = min{f[i-j^2] + 1}.   1=<j*j<=i 
        
        
        // 3. initial state
        // f[0] = 0
        
        //4. order: f[1] - f[n]
        
        if (n <= 0){
            return 0;
        }
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <=i; j++){
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
    }
}
