class Solution {
    public String minimizeError(String[] prices, int target) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        double res = 0;
        
        /**
        
        First assume we are using all floor(n). So the rounding error is total sum of floor diff.
        
        However, after applied floor(n), if the sum is smaller than target, we should actually change some
        floor to ceil. 
        
        And we had a large rounding error, now we want to minimize it. 
        
        So we use a priority queue, ordered by {change from floor to ceil}, in ascending order. 
        
                floor       ceil    diff
        0.7     0           1       -0.4
        2.8     2           3       -0.6
        4.9     4           5       -0.8
        
        
        Error = 0.7 + 0.8 + 0.9
        PriorityQueue: [-0.8, -0.6, -0.4]
        
        sum(floor) = 6. We should change 2 floor() to ceil() to reach target 
        which two to choose? 
        
        Because we want to minimize the error, we choose the value that can reduce error most.
        So we choose -0.8 and -0.6
        
        */
        for (String p : prices) {
            double n = Double.valueOf(p);
            double floor = Math.floor(n);
            double ceil = Math.ceil(n);
            if (floor != ceil) {
                pq.offer((ceil - n) - (n - floor));
            }
            target -= (int) floor;
            res += n - floor;
        }
        if (target < 0 || target > pq.size()) {
            return "-1";
        }
        while (target > 0) {
            res += pq.poll();
            --target;
        }
        return String.format("%.3f", res);
    }
}
