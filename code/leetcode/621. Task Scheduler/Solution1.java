public class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        To avoid leave the CPU with limited choice of tasks and having to sit there cooling down 
        frequently at the end, it is critical the keep the diversity of the task pool for as long as 
        possible.
        
        In order to do that, we should try to schedule the CPU to always try round robin between the 
        most popular tasks at any time. 
        
        
        Time complexity is O(nlog(m)) with n being the number of tasks given to schedule and m being the number of unique tasks. The polling step in PriorityQueue is O(log(m)).

        Space complexity is O(m) since the priority queue and cool down queue can at max have m items.

        */

        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }


        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        
        // use map for frequency because we don't add 0
        pq.addAll(counts.values());

        int totalTime = 0;
        int groupLen = n + 1;
        
        while (!pq.isEmpty()) {
            int worktime = 0;  // actual working time
            List<Integer> group = new ArrayList<Integer>();
            
            for (int i = 0; i < groupLen; i++) {
                if (!pq.isEmpty()) {
                    // select one from the most frequent 
                    group.add(pq.poll());
                    worktime++;
                }
            }
            // add back because we only need 1 of each character
            for (int cnt : group) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            totalTime += !pq.isEmpty() ? groupLen : worktime;
        }
        
        return totalTime;
    }
}
