// pattern: Merge K sorted lists
// time: O(K * log(M))
// space: O(M)
class Node{
    int row;
    int col;
    Node(int r, int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> 
                                        matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        for (int i = 0; i < matrix.length; i++){
            minHeap.offer(new Node(i, 0));
        }
        
        int nodeCount = 0;
        int result = -1;
        while (!minHeap.isEmpty()){
            Node node = minHeap.poll();
            result = matrix[node.row][node.col]; // get the value
            if (++nodeCount == k){
                break;
            }
            if (node.col < matrix[0].length - 1){ // if not the end
                node.col++;
                minHeap.offer(node);
            }
        }
        
        return result;
    }
}
