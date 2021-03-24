class Solution {
    /**
    [X]..[X]
    . . . X
    . . . X
    
    [X].. .
    . . .[X]
    . . . X
        
    */
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    // if this is a start of a battleship
                    if((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
