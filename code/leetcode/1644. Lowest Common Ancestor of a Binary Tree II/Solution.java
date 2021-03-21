class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        
        TreeNode ancestor = findLCA(root, p, q);
        
        if (ancestor == p){
            // when return value is p, there are two cases:
            // (1) p is the ancestor or q  (2) q is not in the tree
            // So we search q in the subtree of p
			// if find q, that means p is LCA, otherwise return null
            return findLCA(p, q, q) == null ? null : ancestor;
        } else if (ancestor == q){
            return findLCA(q, p, p) == null ? null : ancestor;
        }
        
        // if the ancestor is not null, and it not p nor q, then it is the ancestor
        // if it is none, that means both p and q are not in the tree
        // in either case, we just return the ancestor
        return ancestor;
    }
    
    /**
    * For the LCA we obtained(return value), there will be 3 cases:
    * 1. Neither p nor q : LCA of p and q
    * 2. p or q : p is ancestor of q or q is not in the tree, vice varsa.
    * 3. null: p and q not in the tree.
    *
    */
    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null){
            return root;
        }
        
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        
        return null;
        
    }
    
}
