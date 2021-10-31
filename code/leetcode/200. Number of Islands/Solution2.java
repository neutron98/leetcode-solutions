// BFS
class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    /**
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","1"]
      
      ["0","0","0","0","0"],
      ["0","0","0","0","0"],
      ["0","0","0","0","0"],
      ["0","0","0","0","1"]
    
    */
    private void bfs(char[][] grid, int i, int j){

        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        // base case
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(i, j)); // offer this to queue
        while (!queue.isEmpty()){  // visit the neighbors
            Point curr = queue.poll();
            for (int[] dir:directions){
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length){
                    continue;
                }
                if (grid[newRow][newCol] == '0'){
                    continue;
                }
                Point neighbor = new Point(newRow, newCol);
                grid[newRow][newCol] = '0';   // 必须在neighbor这里设置成visited。因为可能两个point的neighbor都包括一个点，这个点被加了两次queue
                queue.offer(neighbor); 
            }
        }
    }
    
    private static class Point{
        int row;
        int col;
        Point(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
}
