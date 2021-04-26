// sort by start or end both works
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
          return 0;
        }
        
        /**
        [1, 2]  [2, 3]   [3, 4]
        
        [1, 3]  [3, 5]
        
        
        if two intervals are overlapping, we want to remove the interval that has the longer end point 
        -- the longer interval will always overlap with more or the same number of future intervals compared to the shorter one
        
        **/
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int prevIndex = 0;
        int count = 0;
        
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= intervals[prevIndex][1]){// not overlapping
                prevIndex = i;
            } else {// overlapping
                if (intervals[i][1] < intervals[prevIndex][1]){
                    // delete previous
                    prevIndex = i;
                    count++;
                } else{
                    // delete current
                    count++;
                }
            }
        }
        
        return count;
    }
}
