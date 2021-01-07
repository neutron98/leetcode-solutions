class MedianFinder {
    // median: x -> half < x.   half > x
    // maxHeap                minHeap
    // smallerNumList         largerNumList
    // assume that : size{smallerNumList} - size{largerNumList} = 0 or 1
    // even: (max{smallerNumList} + min{largerNumList}) / 2
    // odd: max{smallerNumList}
    
    PriorityQueue<Integer> maxHeap;    // smallerNumList
    PriorityQueue<Integer> minHeap;    // largerNumList
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    //  if there are ‘N’ numbers in the list.
    // O(logN)
    public void addNum(int num) {
        // 1. add the number: O(LogN)
        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        // 2. adjust the size by possibly transfering elements
        if (maxHeap.size() > minHeap.size() + 1){
            // begin: maxHeap: [3, 2, 1]    minHeap: [5, 6]  
            // addNum(4)
            // maxHeap: [4, 3, 2, 1]    minHeap: [5, 6]
            // adjust size
            // maxHeap: [3, 2, 1]       minHeap: [4, 5, 6]
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()){
            // begin: [2, 1]     [5, 6]
            // addNum(7)
            //        [2, 1]     [5, 6, 7]
            // adjust
            //        [5, 2, 1]   [6, 7]
            maxHeap.offer(minHeap.poll());
        }
    }
    // O(1)
    public double findMedian() {
        if (maxHeap.isEmpty()){
            return 0.0;
        }
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
