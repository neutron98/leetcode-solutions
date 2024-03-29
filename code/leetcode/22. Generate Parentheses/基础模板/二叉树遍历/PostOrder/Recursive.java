class Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        postorder(root, output);
        return output;
    }
    
    private void postorder(TreeNode root, List<Integer> output) {
        if (root == null) return;
        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.val);
    }
}
