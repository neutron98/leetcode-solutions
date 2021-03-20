/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // 奇技淫巧
    public Node copyRandomList(Node head) {
        // (1) copyNodes
        // (2) copyRandoms
        // (3) split
        
        if (head == null){
            return null;
        }
        
        copyNodes(head);
        copyRandoms(head);
        Node newHead = split(head);
        
        return newHead;
    }
    
    private void copyNodes(Node head){
        Node oldNode = head;
               
        while (oldNode != null){
            Node oldNext = oldNode.next;
            Node newNode = new Node(oldNode.val);
            
            oldNode.next = newNode;
            newNode.next = oldNext;
            
            oldNode = oldNext;
        }
    }
    
    private void copyRandoms(Node head){
        Node oldNode = head;
        Node newNode = head.next;
        
        while (newNode != null){
            Node oldNext = newNode.next;
            if (oldNode.random != null){
                newNode.random = oldNode.random.next;
            }
            
            oldNode = oldNext;

            newNode = oldNode == null? null : oldNode.next;
        }
    }
    
    // split and return the new head
    private Node split(Node head){
        Node oldNode = head;
        Node newHead = head.next;
        Node newNode = head.next;
        
        while (newNode != null){
            Node oldNext = newNode.next;
            Node newNext = oldNext == null? null : oldNext.next;
            // link
            oldNode.next = oldNext;
            newNode.next = newNext;
            
            // update pointer
            oldNode = oldNext;
            newNode = newNext;
        }
        return newHead;
    }
}
