class Solution {
    // Insertion Sort:
    // the head element starts from the first column, then first row
    // so it will not traverse visited diagonals
    // time: O(max(m, n) * min(m, n)^2).  most of the diagonal arrays have a scale of √2*min(m, n), and there are about max(m, n) arrays.
    // space: O(1)
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        if(m == 0){
            return mat;
        }
        int n = mat[0].length;

        for(int i = 1; i < m; i++) {
            sort(mat, i, 0);
        }
        for(int j = 0; j < n; j++) {
            sort(mat, 0, j);
        }
        return mat;
    }
    
    
    private void sort(int[][] mat, int i, int j){
        int m = mat.length;
        int n = mat[0].length;
        while (i < m && j < n){
            int temp = mat[i][j];
            int x = i;
            int y = j;

            while (x - 1 >= 0  && y - 1 >= 0 && temp < mat[x-1][y-1]){
                mat[x][y] = mat[x-1][y-1];
                x--;
                y--;
            }
            mat[x][y] = temp;
            i++;
            j++;
        }
    }
}
