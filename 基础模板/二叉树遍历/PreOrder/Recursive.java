class Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        return helper(root);
    }
    
    public List<Integer> helper(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
}
