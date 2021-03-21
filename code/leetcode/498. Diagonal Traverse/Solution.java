class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int N = matrix.length;
        int M = matrix[0].length;
        
        int row = 0, column = 0;
        
        // keep track of the direction
        int direction = 1;
        
        int[] results = new int[N * M];
        // the index of element stores into results
        int index = 0;
        
        // iterate over all the elements
        while (row < N && column < M){
            // add element
            results[index++] = matrix[row][column];
            // going up: [i, j] -> [i-1, j+1]
            // going down: [i, j] -> [i+1, j-1]
            int new_row, new_column;
            if (direction == 1){
                new_row = row - 1;
                new_column = column + 1;
            } else{
                new_row = row + 1;
                new_column = column - 1;
            }
            
            // check whether the new row and column are within the bound
            // if out of bound, find a new head
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M){
                if (direction == 1){
                    // if [i, j + 1] is in bound, that is the next head
                    if (column < M-1){
                        column++;
                    } else if (column == M - 1){  // can we drop this?
                        // else [i+1, j]
                        row++;
                    }
                } else{
                    if (row < N-1){
                        row++;
                    } else if (row == N - 1){
                        column++;
                    }
                }
                // Flip the direction
                direction = 1 - direction;
            } // end if out of bound
            // if not out of bound
            else{
                row = new_row;
                column = new_column;
            }
        } // end while
        return results;
    }
}
