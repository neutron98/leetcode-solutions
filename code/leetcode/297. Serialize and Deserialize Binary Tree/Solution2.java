// recursion
public class Codec {
    String nullStr = "null", sep = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        
        StringBuilder strBuilder = new StringBuilder();
        serializeHelper(root, strBuilder);
        strBuilder.setLength(strBuilder.length() - 1);
        return strBuilder.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder strBuilder){
        if (node == null){
            strBuilder.append(nullStr);
            strBuilder.append(sep);
            return;
        }
        
        strBuilder.append(node.val);
        strBuilder.append(sep);
        serializeHelper(node.left, strBuilder);
        serializeHelper(node.right, strBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] vals = data.split(sep);
        Queue<String> queue = new LinkedList<>(Arrays.asList(vals));
        return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper(Queue<String> queue){
        if (queue.isEmpty()){
            return null;
        }
        
        String valStr = queue.poll();
        if (valStr.equals(nullStr)){
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(valStr));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
