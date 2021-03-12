package microsoft;

public class BST {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int v){
            this.val = v;
        }
        TreeNode(int v, TreeNode l, TreeNode r){
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    TreeNode root;
    public BST(){
        this.root = null;
    }

    public boolean find(int target){
        if (root == null){
            return false;
        }

        TreeNode curr = root;
        while (curr.val != target){
            if (target > curr.val){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
            if (curr == null){
                return false;
            }
        }
        return true;
    }

    public void insert(int val){
        TreeNode newNode = new TreeNode(val);
        if (root == null){
            root = newNode;
            return;
        }

        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null){
            if (val == curr.val){
                return;
            }
            if (val > curr.val) {
                parent = curr;
                curr = curr.right;
            } else {
                parent = curr;
                curr = curr.left;
            }
        }

        if (val > parent.val){
            parent.right = newNode;
        } else{
            parent.left = newNode;
        }

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // we should find parent and the node in all cases
        /** Case 1: not found */

        TreeNode curr = root;
        TreeNode parent = null;
        boolean isLeftChild = true;
        if (root == null){
            return null;
        }

        while (curr.val != key){
            parent = curr;
            if (key > curr.val){
                curr = curr.right;
                isLeftChild = false;
            } else{
                curr = curr.left;
                isLeftChild = true;
            }
            if (curr == null){
                // not found
                return root;
            }
        }

        if (curr.left == null && curr.right == null){  // Case 2: leaf node
            if (root.val == key){
                return null;
            }
            if (isLeftChild){
                parent.left = null;
            } else{
                parent.right = null;
            }
        } else if (curr.left == null || curr.right == null){  // Case 3: one child
            TreeNode currChild = curr.left != null ? curr.left : curr.right;

            if (curr == root){
                root = currChild;
                return root;
            }

            if (isLeftChild){
                parent.left = currChild;
            } else{
                parent.right = currChild;
            }

        } else { // Case 4: two children
            // we want to substitute the node with a node who has a greater value
            // successor: the smallest node that greater than current node
            TreeNode successor = findSuccessor(curr);
            if (curr == root){
                root = successor;
            } else if (isLeftChild){
                parent.left = successor;
            } else{
                parent.right = successor;
            }

            successor.left = curr.left;

        }
        return root;
    }
    private TreeNode findSuccessor(TreeNode node){
        TreeNode successor = node;
        TreeNode successorParent = node;

        TreeNode curr = node.right;

        while (curr != null){
            successorParent = successor;
            successor = curr;
            curr = curr.left;
        }

        if (successor != node.right){ // disconnect from the successor parent
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;

    }

    public void traverse(){

    }
}
