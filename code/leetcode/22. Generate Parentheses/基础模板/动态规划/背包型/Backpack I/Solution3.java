// 打印出最优策略

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
        
        //优化： 
        // f[w] = max(f[w], f[w-A[i-1]] + A[i-1])
        // 倒序枚举j，这样所需要的f[j-A[i]]不会被提前更新
        
        int n = A.length;
        int[] f = new int[m+1];
        boolean[][] pi = new boolean[n+1][m+1]; // true: using {i} item for weight {w}
        

        for (int i = 1; i <=n; i++){
            for (int w = m; w >= A[i-1]; w--){
                f[w] = Math.max(f[w],f[w-A[i-1]] + A[i-1]);
                if (f[w] == f[w-A[i-1]] + A[i-1]){
                    pi[i][w] = true;
                }
            }
        }
        
        int j = f[m];
        for (int i = n; i >=1; i--){
            if (pi[i][j]){
                System.out.println(A[i - 1]);
                j -= A[i - 1];
            }
        }
  
        return f[m];
    }
}
