// recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // p和q都在左右子树中。这么写是因为base case中只要root是p和q的任意一个就返回root
        // 那么此时left是p或q，right是p或q
        if (left != null && right != null){
            return root;
        }
        //都在左子树中，那么此时left是root.left或者某个存在左子树中的LCA
        if (left != null){
            return left;
        }
        //都在右子树中，那么此时left是root.left或者某个存在左子树中的LCA
        if (right != null){
            return right;
        }
        return null;
    }
}
