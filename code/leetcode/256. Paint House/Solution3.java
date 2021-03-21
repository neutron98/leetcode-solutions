// O(n), O(1)
// 但是hardcoded了颜色
class Solution {
    public int minCost(int[][] costs) {
        // 1. paint the ith house
        // (1) what is the min cost of painting i-1 houses
        // (2) what is the color of i-1?
        
        
        
        // 2. transition function
        // f[i][j] : min total cost of [paint houses 0~i, and paint i with color j] 
        
        // f[i][0] = min{f[i-1][1] + costs[i][0], f[i-1][2] + costs[i][0]}
        
        // 3. init
        
        // 4. order: low-high
        
        // answer: min{f[n][0], f[n][1], f[n][2]}
        
        int n = costs.length;
        if (n == 0){
            return 0;
        }
        
        
        for (int i = 1; i < n; i++){
            costs[i][0] = Math.min(costs[i-1][1] + costs[i][0], costs[i-1][2] + costs[i][0]);
            costs[i][1] = Math.min(costs[i-1][0] + costs[i][1], costs[i-1][2] + costs[i][1]);
            costs[i][2] = Math.min(costs[i-1][0] + costs[i][2], costs[i-1][1] + costs[i][2]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
