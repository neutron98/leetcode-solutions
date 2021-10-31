// DFS
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    traverse(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void traverse(char[][] grid, int r, int c, boolean[][] visited){
        if (r == grid.length || c == grid[0].length || r < 0 || c < 0){
            return;
        }
        if (visited[r][c]){
            return;
        }
        if (grid[r][c] == '0'){
            return;
        }
        
        visited[r][c] = true;
        for (int[] dir: directions){
            traverse(grid, r + dir[0], c + dir[1], visited);
        }
    }
}
