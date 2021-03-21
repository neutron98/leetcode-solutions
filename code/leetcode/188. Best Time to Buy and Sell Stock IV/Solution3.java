// grandyang 版本
// 不理解
// 推荐Solution2
class Solution {
    public int maxProfit(int k, int[] prices) {
        // j = 1, 3, 5:
        // f[i][j] = max{f[i-1][j], f[i-1][j-1] + prices[i-1] - prices[i-2]}
        
        // j = 2, 4:
        // f[i][j] = max{f[i-1][j] + prices[i-1] - prices[i-2], f[i-1][j-1]}
       if (prices == null || prices.length == 0){
            return 0;
        }
        if (k == 0){
            return 0;
        }
        // when k is large(can buy and sell in the same day)
        if (k >= prices.length){
            return solveMaxProfit(prices);
        }
        
        int n = prices.length;
        int[] g = new int[k + 1];// // global[i][j] Max profit: currently on day i，do at most j transactions
        int[] l = new int[k + 1]; // local[i][j] Max profit: currently on day i，do at most j transactions，and the jth transaction's sell is on current day
        
        // global[i][j]=max(local[i][j],global[i-1][j])，
        // local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
        
        for (int i = 0; i < n - 1; i++){
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--){  // j will change only when sell is completed
                
                // 1. purchase stock in day (i-1) and sell today, or 
                // do nothing
                // 2. do nothing
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(g[j], l[j]);
                
            }
        }

        return g[k];
    }
    
    private int solveMaxProfit(int[] prices){
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++){
            if (prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
