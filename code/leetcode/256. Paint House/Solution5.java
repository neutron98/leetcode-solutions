// rolling array
class Solution {
    public int minCost(int[][] costs) {
        // 1.last step:
        // paint with color k
        // the prev was painted with other two colors
        
        
        // 2. transition function
        // for each house i, f[i][0] is the cost of painting i houses, while house i-1 is
        // painted with color k 
        // min cost: (when k == 1)
        // f[i][0] = min{f[i-1][1] + costs[i-1][0] + f[i-1][2] + costs[i-1][0]}
        
        // 3. initial state
        // f[0][k] = 0
        //4. order: low - high
        
        // rolling array
        int m = costs.length;
        if (m == 0){
            return 0;
        }
        
        int n = costs[0].length;
        if (n == 0){
            return 0;
        }
        // f[0][k] = 0;
        int[][] f = new int[2][n]; // rolling array
        f[0] = costs[0];
        
        int prev = 0, curr = 0;

        for (int i = 1; i < m; i++){ // for each house
            prev = curr;
            curr = 1 - prev;
            
            
            for (int color = 0; color < n; color++){ 
                int t = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < n; prevColor++){ // for each prev color 
                    if (color != prevColor){
                        t = Math.min(t, f[prev][prevColor]);
                    }
                }
                f[curr][color] = costs[i][color] + t;
            }
        }
        int min = Integer.MAX_VALUE;
        
        for (int k = 0; k < n; k++){
            min = Math.min(min, f[curr][k]);
        }
        
        return min;
    }
}
