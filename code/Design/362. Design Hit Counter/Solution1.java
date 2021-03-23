
// 不考虑一秒钟多次的情况，只要用queue就行。
// 为什么不用TreeMap? TreeMap的insert和delete需要O(logN)。这题用queue就够了
class HitCounter {
    private Queue<Integer> queue; 
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty()){
            int diff = timestamp - queue.peek();
            if (diff >= 300){
                queue.poll();
            } else{
                break;
            }
        }
        return queue.size();
    }
}
