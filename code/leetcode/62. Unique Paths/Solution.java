class Solution {
    // Time : O(MN), Space: O(MN)
    public int uniquePaths(int m, int n) {
        
        
        // 1. Last Step
        // last position: (m - 1, n - 1)
        // prev: (m - 2, n - 1) or (m - 1, n - 2)
        //             |               |
        //             X      +        Y
        
        // 2. Transfer function
        // f[i][j] = f[i-1][j] + f[i][j-1]
        
        // 3. Initial state and edge cases
        // initial: f[0][0] = 1
        // edge: i=0 or j=0. f[i][j] = 1
        
        // 4. Computing order
        // left - right, top - bottom
        
        int[][] f = new int[m][n];
        int i, j;
        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    f[i][j] = 1;
                } else{
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
