
// Recursive DFS
// Time: O(N + E)
// Space: O(N)

class Solution1 {
    Map<Node, Node> mappings = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        
        return clonedNode(node);
    }
    
    private Node clonedNode(Node node){
        // base case
        if (mappings.containsKey(node)){
            return mappings.get(node);
        }
        // clone current node's value
        Node cloned = new Node(node.val);
        mappings.put(node, cloned); 
        // add neighbors to the cloned node
        for (Node neighbor: node.neighbors){
            cloned.neighbors.add(clonedNode(neighbor));
        }
        // return cloned node
        return cloned;
    }
}
