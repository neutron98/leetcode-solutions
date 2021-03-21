// O(mn), O(n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        if (n == 0){
            return 0;
        }
        // 2 rows of arrays
        int[][] f = new int[2][n];
        
        // 2 pointer
        int prev, curr = 0;
        
        for (int i = 0; i < m; i++){
            prev = curr;
            curr = 1 - curr;
            for (int j = 0; j < n; j++){
                if (i ==0 && j == 0){
                    f[curr][j] = grid[i][j];
                    continue;
                }
                
                // compare
                int temp = Integer.MAX_VALUE;
                if (i > 0){
                    temp = Math.min(temp, f[prev][j]);
                }
                if (j > 0){
                    temp = Math.min(temp, f[curr][j-1]);
                }
                // update
                f[curr][j] = temp + grid[i][j];
            }
        }
        
        return f[curr][n-1];
    }
}
