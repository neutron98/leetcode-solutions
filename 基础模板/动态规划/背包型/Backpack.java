public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // last item: has weight a, put or not put
        // f[i][w]: can put weight w, with first i items 
        // 2. transition function 
        // f[i][w] = f[i-1][w] || f[i-1][w-a]
        // 3. init and edges 
        // f[i][0] = true 
        // f[0][w] = false
        // 4. answer:
        // max w where f[i][w] == true 
        
        int n = A.length;
        int[] f = new int[m+1];
        f[0] = 0;
        
        
        for (int i = 1; i <= n; i++){
            for (int w = m; w >= A[i-1]; w--){
                f[w] = Math.max(f[w], f[w - A[i-1]] + A[i-1]);
            }
        }
         return f[m];
    }
}
