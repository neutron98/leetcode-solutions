class Solution {
                          // {1, 2, 5}     // 11
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int n = coins.length;
        
        // 1. The last step:
        // X, coins[i]
        // (amount - X) -> k
        // amount -> k + 1
        
        // 2. transfer function. 
        // The least # of coins to make up X:
        // f[X] = min{f[X-1] + 1,f[X-2] + 1, f[X-5] + 1}
        
        // 3. Initial state and edge cases
        
        // (1) What if X-1, X-2, X-5 < 0?
        // If we cannot make up X, then f[X] = infinity
        // f[-1] = infinity, f[1](when no coin 1) = infinity
        
        // (2) When do we stop?
        // Initial state (which cannot be computed by f)
        // define: f[0] = 0
        
        
        // 4. Computing order
        // compute f[1], f[2], ... f[amount]
        // when f[X], f[X-1], f[X-2], f[X-5] computed

        f[0] = 0;
        // f[1], f[2], ... f[11]
        for (int i = 1; i <= amount; i++){
            f[i] = Integer.MAX_VALUE;
            // last coin: coins[j]
            for (int j = 0; j < n; j++){
                // f[i] = min(f[i]-coins[0] + 1, ... f[i]-coins[n-1] + 1)
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        
        if(f[amount] == Integer.MAX_VALUE){
            f[amount] = -1;
        }
        return f[amount];
    }
}
