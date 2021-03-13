class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            // go to the leftmost node
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            results.add(curr.val);
            // turn to the right child
            curr = curr.right;
        }
        
        return results;
    }
}
