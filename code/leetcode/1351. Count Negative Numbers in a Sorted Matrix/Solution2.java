class Solution {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            int firstNegativeIndex = search(grid[i]);
            count += n - firstNegativeIndex;
        }
        
        return count;
    }
    
    private int search(int[] row){
        int start = 0, end = row.length - 1;
        
        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if (row[mid] == 0){
                start = mid;
            } else if (row[mid] < 0){
                end = mid;
            } else{
                start = mid;
            }
        }
        
        if (row[start] < 0){
            return start;
        }
        if (row[end] < 0){
            return end;
        }
        
        return row.length;
    }
}
