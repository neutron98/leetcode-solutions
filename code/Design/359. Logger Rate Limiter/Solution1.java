class Logger {
    // During interview, two things to clarify:
    // 1. would the input always ordered by timestamp? (queue/priorityqueue)
    // 2. if a message is not printed, should we add it into the queue or just discard it?
    private static class MessagePair{
        private String message;
        private int timestamp;
        
        MessagePair(String m, int t){
            this.message = m;
            this.timestamp = t;
        }
    }
    // [1, {2, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11}]
    // 1. currTimestamp.  discard all messages with time <= currTimestamp - 10
    // 2. if this message is in the queue
    
    private Queue<MessagePair> queue;
    private Set<String> set;
    /** Initialize your data structure here. */
    public Logger() {
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10){
            MessagePair p = queue.poll();
            set.remove(p.message);
        }
        if (set.contains(message)){
            return false;
        } else{
            queue.offer(new MessagePair(message, timestamp));
            set.add(message);
            return true;
        }
    }
}
