
// 滚动数组，O(NK), O(K)
class Solution {
    public int maxProfit(int k, int[] prices) {
        // j = 1, 3, 5:
        // f[i][j] = max{f[i-1][j], f[i-1][j-1] + prices[i-1] - prices[i-2]}
        
        // j = 2, 4:
        // f[i][j] = max{f[i-1][j] + prices[i-1] - prices[i-2], f[i-1][j-1]}
       if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        
        if (n == 1){
            return 0;
        }
        
        if (k > n / 2){
            return solveMaxProfit(prices);
        }
        
        int[][] f = new int[2][2*k+2];
        int old, now = 0;
        f[now][1] = 0;
        
        for (int j = 2; j <= 2 * k + 1; j++){
            f[0][j] = Integer.MIN_VALUE;
        }
        
        for (int i = 1; i <= n; i++){
            old = now;
            now = 1- now;
            for (int j = 1; j <= 2 * k + 1; j += 2){
                if (i > 1 && j > 1 && f[old][j-1] != Integer.MIN_VALUE){
                    f[now][j] = Math.max(f[old][j], f[old][j-1] + prices[i-1] - prices[i-2]);
                } else{
                    f[now][j] = f[old][j];
                }
            }
            for (int j = 2; j <= 2 * k; j += 2){
                if (i > 1 && f[old][j] != Integer.MIN_VALUE){
                    f[now][j] = Math.max(f[old][j] + prices[i-1] - prices[i-2], f[old][j-1]);
                } else{
                    f[now][j] = f[old][j-1];
                }
            }
        }
        
        int maxProfit = 0;
        for (int j = 1; j <= 2*k+1; j+=2){
            maxProfit = Math.max(maxProfit, f[now][j]);
        }
        
        return maxProfit;
    }
    
    
    private int solveMaxProfit(int[] prices){
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i+1] > prices[i]){
                res += prices[i+1] - prices[i];
            }
        }
        return res;
    }
}
