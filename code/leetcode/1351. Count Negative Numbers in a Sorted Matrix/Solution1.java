class Solution {
    // O(M + N)
    public int countNegatives(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int row = M - 1, col = 0;
        int count = 0;
        
        while(row >= 0 && col < N){
            if(grid[row][col] < 0){
                count += N - col;
                row--;
            }else{
                col++;
            }
        }

        return count;
    }
}
