class Solution {
    
    /**
    
    int rowIndex = 3 * (i / 3);
    int colIndex = 3 * (i % 3);
    
    i   0 1 2 3 4 5 6 7 8
    
    r   0 0 0 3 3 3 6 6 6
    c   0 3 6 0 3 6 0 3 6
    
    j   0 1 2 3 4 5 6 7 8
    j/3 0 0 0 1 1 1 2 2 2
    j%3 0 1 2 0 1 2 0 1 2
    
    */
    
    
     
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // row-col or col-row 
        for (int i = 0; i < n; i++){
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            // start row and col of cube
            int rowIndex = 3 * (i / 3);
            int colIndex = 3 * (i % 3);
            
            for (int j = 0; j < n; j++){
                if (board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                
                if (board[j][i] != '.' && !cols.add(board[j][i])){
                    return false;
                }
                
                
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
                   && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])){
                    return false;
                }                
            }
        }
        return true;
    }
}
