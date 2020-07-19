// with path printing

class Solution {
    // where it comes from
    public static int LEFT = 1;
    public static int UP = 2;
    
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        // f[i][j] = min{f[i-1][j], f[i][j-1])
        // 3. initial and edge cases:
        // f[0][0] = grid[0][0]
        // when i == 0:
        // f[0][j] = f[0][j-1]
        // when j == 0:
        // f[i][0] = f[i-1][0]
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m][n];
        // 0: go right, 1: go down
        int[][] f = new int[2][n];
        
        int old = 0;
        int now = 0;
        for (int i = 0; i < m; i++){
            old = now;
            now = 1- now;
            
            for(int j = 0; j < n; j++){

                if (i == 0 && j == 0){
                    f[now][j] = grid[i][j];
                    continue;
                }
                
                int temp = Integer.MAX_VALUE;
                if (i > 0){
                    temp = Math.min(temp, f[old][j]);
                }
                if (j > 0){
                    temp = Math.min(temp, f[now][j-1]);
                }
                if (temp == f[old][j] && i-1 >= 0){  // edge case:[[0,0],[0,0]]
                    p[i][j] = UP;
                } else if(temp == f[now][j-1] && j-1 >= 0){
                    p[i][j] = LEFT;
                }

                f[now][j] = grid[i][j] + temp;
            }
        }
        
        List<Integer> path = new ArrayList<>();
        int x = m - 1;
        int y = n - 1;
        while (x > 0 || y > 0){
            path.add(grid[x][y]);
            if (p[x][y] == LEFT){
                y--;
            } else{ // trace up
                x--;
            }
            if (x == 0 && y == 0){
                break;
            }
        }
        
        System.out.print(grid[0][0]);
        for (int i = path.size() - 1; i >= 0; i--){
            System.out.print("->" + path.get(i));
        };
        
        return f[now][n-1];
    }
}
