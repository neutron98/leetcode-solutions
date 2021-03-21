class Solution {
    Set<Integer> squares = new HashSet<>();
    public int numSquares(int n) {
        if (n <= 0){
            return 0;
        }
        
        
        for (int i = 1; i * i <= n; i++){
            squares.add(i * i);
        }
        
        // if n can be divided by [count] squares 
        int count = 1;
        while (count <= n){
            if (isDividedBy(n, count)){
                return count;
            }
            count++;
        }
        return count;
    }
    
    
    private boolean isDividedBy(int n, int count){
        if (count == 1){
            return squares.contains(n);
        }
        
        for (int square: squares){
            if(isDividedBy(n - square, count - 1)){
                return true;
            }
        }
        return false;
    }
}
