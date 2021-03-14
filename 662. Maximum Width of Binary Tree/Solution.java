class Solution {
    class IndexedNode{
        TreeNode node;
        int colIndex;
        IndexedNode(TreeNode node, int colIndex){
            this.node = node;
            this.colIndex = colIndex;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if (root == null){
            return maxWidth;
        }
        
        Queue<IndexedNode> queue = new LinkedList<>();
        queue.offer(new IndexedNode(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            IndexedNode head = queue.peek();
            IndexedNode curr = null;
            for (int i = 0; i < size; i++){
                curr = queue.poll();
                if (curr.node.left != null){
                    queue.offer(new IndexedNode(curr.node.left, 2 * curr.colIndex));
                }
                if (curr.node.right != null){
                     queue.offer(new IndexedNode(curr.node.right, 2 * curr.colIndex + 1));
                }
                
            }
            
            maxWidth = Math.max(maxWidth, curr.colIndex - head.colIndex + 1);
            
        }
        return maxWidth;
    }
}
