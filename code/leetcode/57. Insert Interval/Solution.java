class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0){
            int[][] merged = new int[1][2];
            merged[0] = newInterval;
            return merged;
        }
        List<int[]> result = new ArrayList<>();
        int i = 0;
        // copy old intervals
        while (i < intervals.length && intervals[i][1] < newInterval[0]){ // curr end < new start
            result.add(intervals[i++]);
        }
        
        /** merge overlappingf intervals
        * new:  ---
        * old: -- --
        *
        * new: -----
        * old: -- --
        */
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){ // curr start < new end
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        // insert the new Interval
        result.add(newInterval);
        // copy remaining intervals
        while (i < intervals.length){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
