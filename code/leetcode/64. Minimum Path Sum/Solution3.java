// O(mn), O(1)
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
        
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                
                if (j == 0){
                    grid[i][0] += grid[i-1][0];
                    continue;
                }
                if (i == 0){
                    grid[0][j] += grid[0][j-1];
                    continue;
                }
                
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
}
