
// Optimal: O(n*k), O(1)
class Solution {
    public int minCostII(int[][] costs) {
        
        int n = costs.length;
        if (n == 0){
            return 0;
        }
        
        int C = costs[0].length;
        if (C == 0){
            return 0;
        }
        
        
        for (int i = 1; i < n; i++){ // for each row (house)
            
            // find the min color and 2nd min color from its prev row 
            int minColor = -1, secondMinColor = -1;
            
            for (int color = 0; color < C; color++){ // iterate through the row to find colors
                int cost = costs[i-1][color]; 
                if (minColor == -1 || cost < costs[i-1][minColor]){ // curr color is the min
                    // update the min
                    secondMinColor = minColor;
                    minColor = color;
                } else if(secondMinColor == -1 || cost < costs[i-1][secondMinColor]){ // 2nd min
                    secondMinColor = color;
                }
            }
            
            // for current colors: update cost
            for (int k = 0; k < C; k++){
                if (minColor != k){ // if not the same as prev minColor
                    costs[i][k] += costs[i-1][minColor];// use prev minColor
                } else{ // otherwise, use second min
                    costs[i][k] += costs[i-1][secondMinColor];
                }
            }
        }
        
        // find the min cost in the last row

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < C; j++){
            minCost = Math.min(minCost, costs[n-1][j]);
        }
        
        return minCost;
    }
}
