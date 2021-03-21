class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            results.add(curr.val);
            
            if (curr.right != null){
                stack.push(curr.right);
            }
            if (curr.left != null){
                stack.push(curr.left);
            }
        }
        return results;
    }
}
