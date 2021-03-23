//考虑一秒钟多次hit的情况，需要merge。只要merge这一秒的就行，所以不需要另一个map。但是要deque因为要getLast
class HitCounter {
    private static class HitEntry{
        private int timestamp;
        private int count;
        HitEntry(int timestamp){
            this.timestamp = timestamp;
            this.count = 1;
        }
    }
    
    private Deque<HitEntry> deque; 
    private int totalCount;
    /** Initialize your data structure here. */
    public HitCounter() {
        deque = new LinkedList<>();
        totalCount = 0;
    }
    
    /** Record a hit.
    
    [1, 1, 1, 1, 1] -> [1, 5]
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (deque.isEmpty() || deque.getLast().timestamp != timestamp){
            deque.addLast(new HitEntry(timestamp));
        } else if (!deque.isEmpty() && deque.getLast().timestamp == timestamp){
            // merge the count
            deque.getLast().count++;
        }
        totalCount++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty()){
            int diff = timestamp - deque.peek().timestamp;
            if (diff >= 300){
                HitEntry e = deque.poll();
                totalCount -= e.count;
            } else{
                break;
            }
        }
        return totalCount;
    }
}
