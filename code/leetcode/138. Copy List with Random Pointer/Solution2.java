class Solution {
    // iterative
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        
        Node oldNode = head;
        while (oldNode != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            
            // move one node ahead
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return map.get(head);
    }
    
    private Node getClonedNode(Node oldNode){
        if (oldNode == null){
            return null;
        }
        
        if (map.containsKey(oldNode)){
            return map.get(oldNode);
        }
        
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        return newNode;
    }
}
