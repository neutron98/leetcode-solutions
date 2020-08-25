// Iteration
public class Codec {
    String n = "null", sep = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }       
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                if (curr != null){
                    sb.append(curr.val);
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else{ // if it is null
                    sb.append(n);
                }
                
                sb.append(sep); // append separater
            }
        } // end while
        sb.append("]");
        return sb.toString(); 
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty() || data.equals("[]")){
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(sep);
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        boolean isLeftChild = true;
        
        int parentIndex = 0;
        
        for (int i = 1; i < vals.length; i++){
            if (!vals[i].equals(n)){
                // construct current node
                TreeNode curr = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild){
                    queue.get(parentIndex).left = curr;
                } else{
                    queue.get(parentIndex).right = curr;
                }
                
                // add current to queue
                queue.add(curr);
            }
                
            if (!isLeftChild){ // if the current node is right child
                // move parent to next element
                parentIndex++;
            }
                isLeftChild = !isLeftChild;
        }
        return root;       
    }
}
