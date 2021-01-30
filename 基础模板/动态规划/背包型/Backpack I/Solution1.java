// O(mn), O(mn)
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        
        // 1.
        // f[i][w] = if can make up weight w.   w: 0 ~ N
        
        // 常见错误： [3 9 5 2]
        // 2.transition function: 
        // f[i][w] = f[i-1][w]  or f[i-1][w-A[i-1]]
        
        
        // 3. initial and edge:
        // f[0][0] = true  f[0][w] = false
        
        // w-A[i-1] >=0 when latter
        
        // 4. answer: max(f[n][i])
        
        
        int n = A.length;
        boolean[][] f = new boolean[n+1][m+1];
        
        f[0][0] = true;
        
        for (int i = 1; i <=m; i++){
            f[0][i] = false;
        }
        
        for (int i = 1; i <=n; i++){
            for (int w = 0; w <=m; w++){
                if (w >= A[i-1]){
                    f[i][w] = f[i-1][w] || f[i-1][w-A[i-1]];
                } else{
                    f[i][w] = f[i-1][w];
                }
            }
        }
        
        int res = 0;
        for (int i = m; i >= 0; i--){
            if (f[n][i] == true){
                res = i;
                break;
            }
        }
        return res;
    }
}
