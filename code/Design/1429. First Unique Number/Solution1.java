// Solution 1: Queue + Map.
// queue stores only unique elements, but isUnique can be false when a new entry is added later
// delete in queue is O(N). So we do a lazy-delete (only delete when showFirstUnique() is called)
class FirstUnique {
    Queue<Integer> queue;
    
    Map<Integer, Boolean> isUnique;
    public FirstUnique(int[] nums) {
        this.queue = new LinkedList<>();
        this.isUnique = new HashMap<>();
        
        for (int num: nums){
            this.add(num);
        }
    }
    // Lazy-remove
    public int showFirstUnique() {
        // remove non-unique numbers
        while (!queue.isEmpty() && !isUnique.get(queue.peek())){
            queue.poll();
        }
        
        if (!queue.isEmpty()){
            return queue.peek();
        }
        
        return -1;
    }
    
    public void add(int value) {
        if (!isUnique.containsKey(value)){
            queue.offer(value);
            isUnique.put(value, true);
        } else if (isUnique.get(value)){
            isUnique.put(value, false);
        }
    }
}
