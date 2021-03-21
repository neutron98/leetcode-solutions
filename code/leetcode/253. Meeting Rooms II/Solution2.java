// Priority Queue
// Time: O(N*LogN)
// Space: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        for (int[] interval: intervals){
            if (!pq.isEmpty() && interval[0] >= pq.peek()[1]){ // a room is free
                pq.poll();
            }
            pq.add(interval);
        }
        
        return pq.size();
    }
}
