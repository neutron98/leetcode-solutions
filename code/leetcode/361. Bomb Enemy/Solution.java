// O(MN), O(MN)
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        // 1. static status
        // Assume we can put a bomb in E or W
        // put a bomb in (i, j)
        
        // if just look at the direction [UP]
        // number of enemies it can kill: 
        // if (i, j) is:
        // empty space: (i-1, j) UP
        // enemy: (i-1, j) UP + 1
        // wall: 0
        
        
        // 2. transition function
        // up[i][j] = 
        // up[i-1][j], if empty
        // up[i-1][j] + 1, if enemy
        // 0, if wall
        
        // 3. initial state:
        // up[0][j] = 0, if not enemy
        // up[0][j] = 1, if enemy
        
        // 4. Compting order
        // up: top-down
        // down: down-up
        // left: left-right
        // right: right-left
        
        // 5. result
        // if (i, j) is an empty space:
        // up[i][j] + down[i][j] + left[i][j] + right[i][j]
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        
        // up
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){              
                if (grid[i][j] == 'W'){
                    up[i][j] = 0;
                    left[i][j] = 0;
                    continue;
                }
                up[i][j] = (grid[i][j] == 'E') ? 1 : 0;  // enemy or space
                left[i][j] = (grid[i][j] == 'E') ? 1 : 0;
                if (i > 0){
                    up[i][j] += up[i-1][j];
                }
                if (j > 0){
                    left[i][j] += left[i][j-1];
                }
            }
        }
        
        
        // down
        for (int i = m - 1; i >= 0; i--){
            for (int j = 0; j < n; j++){              
                if (grid[i][j] == 'W'){
                    down[i][j] = 0;
                    continue;
                }
                down[i][j] = (grid[i][j] == 'E') ? 1 : 0;  // enemy or space
                
                if (i < m - 1){
                    down[i][j] += down[i+1][j];
                }
            }
        }
        
        // right
        for (int i = 0; i < m; i++){
            for (int j = n - 1; j >= 0; j--){              
                if (grid[i][j] == 'W'){
                    right[i][j] = 0;
                    continue;
                }
                right[i][j] = (grid[i][j] == 'E') ? 1 : 0;  // enemy or space
                if (j < n - 1){
                    right[i][j] += right[i][j+1];
                }
            }
        }
        
        // find max result
        int res = 0;  // if only one cell, also return 0 no matter what type it is
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0'){
                    int t = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    res = Math.max(t, res);
                }
            }
        }
        
        return res;
    }
}
