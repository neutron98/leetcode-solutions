// 好像可以不用管重量超不超
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // 1. f[i][w]: first {i} items, max size {w}. max value 
        // 2. f[i][w] = max(f[i-1][w], f[i-1][w-A[i-1]] + V[i-1])
        // where w-A[i-1] >= 0
        // 3. init 
        // f[0][0...w] = 0
        // f[0...n][0] = 0 
        
        // 4. res 
        // f[n][m] 
        
        
        int n = A.length;
        int[][] f = new int[n+1][m+1];
        
        for (int j = 0; j <= m; j++){
            f[0][j] = 0;
        }
        
        for (int i = 0; i <= n; i++){
            f[i][0] = 0;
        }
        
        for (int i = 1; i <= n; i++){
            for (int w = 1; w <= m; w++){
                f[i][w] = f[i-1][w];
                if (w >= A[i-1]){
                    f[i][w] = Math.max(f[i][w], f[i-1][w-A[i-1]] + V[i-1]);
                }
            }
        }
        
        return f[n][m];
        
    }
}
