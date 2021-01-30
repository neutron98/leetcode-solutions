class Iterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;
        while (curr != null || !stack.empty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == last){
                results.add(curr.val);
                stack.pop();
                last = curr;
                curr = null;
            } else{
                curr = curr.right;
            }
        }
        return results;
    }
}
