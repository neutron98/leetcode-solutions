public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        
        // f[i][w]: maximum size for first {i} items
        // 2.
        // f[i][w] = max(f[i-1][w], f[i-1][w-A[i-1]] + A[i-1])
        
        
        // 3. initial and edge:
        // f[0][w] = 0
        
        // w-A[i-1] >=0 when latter
        
        // 4. answer: f[n][m]
        
        
        int n = A.length;
        int[][] f = new int[n+1][m+1];
        

        for (int i = 1; i <=n; i++){
            for (int w = 0; w <=m; w++){
                f[i][w] = f[i-1][w];
                if (w >= A[i-1]){
                    f[i][w] = Math.max(f[i][w],f[i-1][w-A[i-1]] + A[i-1]);
                }
            }
        }
  
        return f[n][m];
    }
}
