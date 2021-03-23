// Solution 2: Actively delete when add() is called
class FirstUnique {
    private Set<Integer> setQueue;
    
    Map<Integer, Boolean> isUnique;
    public FirstUnique(int[] nums) {
        this.setQueue = new LinkedHashSet<>();
        this.isUnique = new HashMap<>();
        
        for (int num: nums){
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        // remove non-unique numbers
        if (!setQueue.isEmpty()){
            return setQueue.iterator().next();
        }
        
        return -1;
    }
    
    public void add(int value) {
        if (!isUnique.containsKey(value)){
            setQueue.add(value);
            isUnique.put(value, true);
        } else if (isUnique.get(value)){
            setQueue.remove(value);
            isUnique.put(value, false);
        }
    }
}
