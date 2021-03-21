// Time: O(2 * nlogk) = O(nlogk)
// Space: O(k) + O(n) = O(n)
class MedianFinder{
    // numbers < median
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // numbers > median
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    void addNum(int num){
        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else{
            minHeap.offer(num);
        }
        balanceHeaps();
    }
    
    void removeNum(int num){
        if (num <= maxHeap.peek()){
            maxHeap.remove(num);
        } else{
            minHeap.remove(num);
        }
        balanceHeaps();
    }
    
    // balance the heaps to ensure size{maxHeap} - size{minHeap} = 0 or 1
    private void balanceHeaps(){
        // [4, 3, 2, 1]     [6, 7]
        if (maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()){
            // [4, 3]      [5, 6, 7]
            maxHeap.offer(minHeap.poll());
        }
    }
    
    double getMedian(){
        if (maxHeap.isEmpty()){
            return 0f;
        }
        if (maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/ 2.0 + minHeap.peek() / 2.0;
        } else{
            return maxHeap.peek();
        }
    }
}


class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MedianFinder finder = new MedianFinder();
        double[] result = new double[n - k + 1];
        int l = 0;
        for (int r = 0; r < n; r++){
            finder.addNum(nums[r]);
            // if we have at least 'k' elements
            if (r >= k - 1){
                // store the median
                result[l] = finder.getMedian();
                // remove the start element
                int numToRemove = nums[l];
                finder.removeNum(numToRemove);
                l++;
            }
        }
        return result;
    }
}
