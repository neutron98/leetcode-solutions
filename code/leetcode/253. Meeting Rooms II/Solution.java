// 扫描线算法
// Time: O(NlogN)
// Space: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // simulation
        /*
        *     |__| 
        *       |___|
        *          |___| 
        *             |__|
        *
        * counts
        *
        * starts: 
        *     | |  |  |
        *          i
        * ends:
        *        |  |  | |
        *        j
        */
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i <n; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0, j = 0;
        int count = 0;
        while (i < n){
            if (starts[i] < ends[j]){
                count++;
            } else{
                j++;
            }
            i++;
        }
        return count;
    }
}
