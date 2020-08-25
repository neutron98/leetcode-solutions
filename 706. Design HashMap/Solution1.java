// 为什么array会抛出ConcurrentModificationException？
// 要用ArrayList才能通过测试


class Pair<K, V>{
    public K k;
    public V v;
    public Pair(K _k, V _v){
        this.k = _k;
        this.v = _v;
    }
}

class Bucket{
    private List<Pair<Integer, Integer>> bucket;
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    

    public Integer get(Integer key){
        for (Pair<Integer, Integer> pair: this.bucket){
            if (pair.k.equals(key)){
                return pair.v;
            }
        }
        return -1;
    }
    
    public void update(Integer key, Integer value){
        boolean found = false;
        for (Pair<Integer, Integer> pair: this.bucket){
            if (pair.k.equals(key)){
                pair.v = value;
                found = true;
            }
        }
        if (!found){
            this.bucket.add(new Pair<Integer, Integer>(key, value));
        }
    }
    
    public void remove(Integer key){
         for (Pair<Integer, Integer> pair: this.bucket){
            if (pair.k.equals(key)){
                this.bucket.remove(pair);
            }
        }
    }
}
class MyHashMap {
    private int length;
    private Bucket[] table;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.length = 2069;
        this.table = new Bucket[length];
        
        for (int i = 0; i < this.length; i++){
            this.table[i] = new Bucket();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % this.length;
        this.table[hashKey].update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % this.length;
        return this.table[hashKey].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.length;
        this.table[hashKey].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
