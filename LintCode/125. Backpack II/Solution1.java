public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        
        // (1)if first {n-1} items can make up W, max value is V, then the first {n} items
        // can also make up W, max value is V
        
        // (2) if first {n-1} items can make up W-A[n-1], max value is V-V[n-1]
        // then plus last item can make W, max value is V 
        
        // f[i][w] = max value when using first {i} items to make up {w}
        // -1 means cannot make
        // f[i][w] = max{f[i-1][w], f[i-1][w-A[i-1]] + V[i-1]}  where w>=A[i-1] && f[i-1][w-A[i-1]] != -1}
        // 重量不超，能拼出来
        
        // 3. init: f[0][0] = 0, f[0][1...M] = -1
        // 4. answer: max{f[N][j]
        
        int n = A.length;
        int[][] f = new int[n+1][m+1];
        
        f[0][0] = 0;
        for (int w = 1; w <= m; w++){
            f[0][w] = -1;
        }
        
        for (int i = 1; i <= n; i++){
            for (int w = 0; w <= m; w++){
                f[i][w] = f[i-1][w];
                if (w >= A[i-1] && f[i-1][w-A[i-1]] != -1){
                    f[i][w] = Math.max(f[i][w], f[i-1][w-A[i-1]] + V[i-1]);
                }
            }
        }
        
        int res = 0;
        for (int w = 0; w <= m; w++){
            if (f[n][w] != -1){
                res = Math.max(f[n][w], res);                
            }
        }
        return res;
    }
}
