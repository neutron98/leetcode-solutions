// O(N), O(N)
class Solution {
    public int maxProfit(int[] prices) {
        // j = 1, 3, 5:
        // f[i][j] = max{f[i-1][j], f[i-1][j-1] + prices[i-1] - prices[i-2]}
        
        // j = 2, 4:
        // f[i][j] = max{f[i-1][j] + prices[i-1] - prices[i-2], f[i-1][j-1]}
        
        
        // initial state:
        // after 0 days: can only be on stage 1
        // f[0][1] = 0, f[0][2] = f[0][3] = f[0][4] = f[0][5] = negative infinity
        
    
        // edge cases:
        // if (j - 1) < 1 or (i-2) < 0, that term does not count into max
        
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        
        if (n == 1){
            return 0;
        }
        
        int[][] f = new int[n+1][6];
        
        f[0][1] = 0;
        for (int j = 2; j <= 5; j++){
            f[0][j] = Integer.MIN_VALUE;
        }
        
        for (int i = 1; i <= n; i++){
            // j = 1, 3, 5
            for (int j = 1; j <=5; j += 2){
                if (i > 1 && j > 1 && f[i-1][j-1] != Integer.MIN_VALUE){// if we have a stock in prev day
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-1] + prices[i-1] - prices[i-2]);
                } else{
                    f[i][j] = f[i-1][j];
                }
            }
            
            // j = 2, 4
            for (int j = 2; j <= 4; j += 2){
                
                if (i > 1 && f[i-1][j] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i-1][j] + prices[i-1] - prices[i-2], f[i-1][j-1]);
                } else{
                    f[i][j] = f[i-1][j-1];
                }
            }
        }
        
        return Math.max(f[n][1], Math.max(f[n][3], f[n][5]));
    }
}
