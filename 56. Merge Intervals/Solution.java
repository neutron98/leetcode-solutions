class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval: intervals){
            if (interval[0] <= end){ // overlapping intervals
                end = Math.max(end, interval[1]);
            } else{ // non-overlapping intervals, add previous interval and update
                results.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        // add the last interval
         results.add(new int[]{start, end});
        return results.toArray(new int[results.size()][]);
    }
}
