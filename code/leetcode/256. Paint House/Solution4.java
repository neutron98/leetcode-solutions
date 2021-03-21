// O(n), O(1) 
class Solution {
    public int minCost(int[][] costs) {
        // 1. paint the ith house
        // (1) what is the min cost of painting i-1 houses
        // (2) what is the color of i-1?
        
        
        
        // 2. transition function
        // f[i][j] : min total cost of [paint houses 0~i, and paint i with color j] 
        
        // f[i][0] = min{f[i-1][1] + costs[i][0], f[i-1][2] + costs[i][0]}
        
        // 3. init
        // 序列型动态规划的好处：前0个的初始值都是0
        // f[0][0] = f[0][1] = f[0][2] = 0
        
        // 4. order: low-high
        
        // answer: min{f[n][0], f[n][1], f[n][2]}
        
        int n = costs.length;
        if (n == 0){
            return 0;
        }
        

        for (int i = 1; i < n; i++){
            for (int j = 0; j < 3; j++){
                // init
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++){
                    if (j != k){
                        min = Math.min(min, costs[i-1][k]);
                    }
                }
                costs[i][j] += min;
            }
           
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
