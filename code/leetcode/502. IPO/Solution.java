// time: O(Nlogk) 
// space: O(N)
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (a,b) -> Integer.compare(Capital[a], Capital[b]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (a,b) -> Integer.compare(Profits[b], Profits[a]));
        // insert all project capitals to a min-heap
        for (int i = 0; i < n; i++){
            minCapitalHeap.offer(i);
        }
         // find all projects that can be selected within the available capital and insert them in a max-heap
        int availableCapital = W;
        // select the best 'k' projects
        for (int i = 0; i < k; i++){
            while (!minCapitalHeap.isEmpty() && Capital[minCapitalHeap.peek()] <= availableCapital){
                // poll from minCapitalHeap means 'selected'
                maxProfitHeap.offer(minCapitalHeap.poll());
            }
             // terminate if we are not able to find any project within availableCapital
            if (maxProfitHeap.isEmpty()){
                break;
            }
            availableCapital += Profits[maxProfitHeap.poll()];
        }
        return availableCapital;
    }
}
