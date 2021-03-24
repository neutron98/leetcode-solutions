class Solution {
    public int minSteps(int n) {
        /**
        6个A:
        
        A A A A A A: 'A' + 6
        AA AA AA: 'AA' + 3
        AAA AAA: 'AAA' + 2
        */
        
        /**
        
        dp[i]: min steps to get i numbers of 'A'
        */
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 0;
        
        
        for (int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 2; j <= i; j++){//j: 砍多少份
                if (i % j != 0){
                    continue;
                }
                int k = i / j;  // 每份是k个
                // 'AA' -> 'AA AA AA'
                // 在得到k个之后,一次ctrl + c,再加j - 1次ctrl + v
                dp[i] = Math.min(dp[i], dp[k] + 1 + j - 1);
                // break;  找到'AAA'之后就break.近似贪心
            }
        }
        
        return dp[n];
    }
}
