// O(mn), O(mn)
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
        
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i ==0 && j == 0){
                    f[i][j] = grid[i][j];
                    continue;
                }
                
                // compare
                int temp = Integer.MAX_VALUE;
                if (i > 0){
                    temp = Math.min(temp, f[i-1][j]);
                }
                if (j > 0){
                    temp = Math.min(temp, f[i][j-1]);
                }
                // update
                f[i][j] = temp + grid[i][j];
            }
        }
        
        return f[m-1][n-1];
    }
}
