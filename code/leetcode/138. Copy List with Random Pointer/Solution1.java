// recursive
class Solution {
    
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return copyNode(head);        
    }
    
    private Node copyNode(Node node){
        if (node == null){
            return null;
        }
        
        if (map.containsKey(node)){
            return map.get(node);
        }
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        newNode.next = copyNode(node.next);
        newNode.random = copyNode(node.random);
        
        return newNode;
    }
    
}
