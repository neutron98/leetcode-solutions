
class Node{
    int arrayIndex;
    int elementIndex;
    Node(int a, int e){
        this.arrayIndex = a;
        this.elementIndex = e;
    }
}
// Time: O(N * LogK)
// Space: O(K)



class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> 
                                                         nums.get(n1.arrayIndex).get(n1.elementIndex) - nums.get(n2.arrayIndex).get(n2.elementIndex));
        
        
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        int currentMaxNum = Integer.MIN_VALUE;
        
        // insert heads
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) != null){
                minHeap.offer(new Node(i, 0));
                currentMaxNum = Math.max(currentMaxNum, nums.get(i).get(0));
            }
        }
        
            
        // stop when any of the lists is completed
        while (minHeap.size() == nums.size()){
            // take the smallest (top) element form the min heap
            Node node = minHeap.poll();
            // if it gives us smaller range, update the ranges
                // if the array of the top element has more elements, insert the next element in the heap
            int val = nums.get(node.arrayIndex).get(node.elementIndex);
            if (rangeEnd - rangeStart > currentMaxNum - val){
                rangeStart = val;
                rangeEnd = currentMaxNum;
            }
            
            if (node.elementIndex < nums.get(node.arrayIndex).size() - 1){
                node.elementIndex++;
                minHeap.offer(node);
                currentMaxNum = Math.max(currentMaxNum, nums.get(node.arrayIndex).get(node.elementIndex));
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }
}
