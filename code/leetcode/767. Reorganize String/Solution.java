class Solution {
    public String reorganizeString(String S) {
        // 1. Frequency count
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char s : S.toCharArray()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // 2. add to a max heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        // builder
        StringBuilder sb = new StringBuilder();
        
        
        // 3. Add chars to sb alternatively until there is one char left
        while(maxHeap.size() > 1) {
            // Get the first and next entry
            char curr = maxHeap.poll();
            char next = maxHeap.poll();
            
            // Append the chars to StringBuilder
            sb.append(curr);
            sb.append(next);
            
            // Subtract the count by 1
            map.put(curr, map.get(curr) - 1);
            map.put(next, map.get(next) - 1);

            // add back
            if(map.get(curr) > 0) {
                maxHeap.offer(curr);
            }
            
            if(map.get(next) > 0) {
                maxHeap.offer(next);
            }
        }
        // 4. check the last char
        if (!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if (map.get(last) > 1){
                return "";
            }
            sb.append(last);
        }
        
        
        return sb.toString();
    }
} 
