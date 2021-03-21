// Time: O(MN), Space: O(MN)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0){
            return 0;
        }
        
        // Scenarios for f[i][j]:
        // (1) obstacle: 0
        // (2) 1st column/1st row: 1 if no current and previous obstacle
        // (3) otherwise: f[i-1][j] + f[i][j-1]
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
                // (1) obstacle
                if (obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                    continue;
                }
                // (2) top-left
                if (i ==0 && j == 0){
                    f[i][j] = 1;
                    continue;
                }
                
                if (i > 0){
                    f[i][j] += f[i-1][j];
                }
                
                if (j > 0){
                    f[i][j] += f[i][j-1];
                }

            }
        }
        return f[m-1][n-1];
    }
}
