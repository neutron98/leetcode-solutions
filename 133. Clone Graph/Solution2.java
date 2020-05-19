class Solution {
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        
        Map<Node, Node> mappings = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        mappings.put(node, new Node(node.val));
        queue.offer(node);
        
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            for (Node neighbor: curr.neighbors){
                if (!mappings.containsKey(neighbor)){ 
                    // if the neighbor is not copied
                    // add mappings of the neighbor
                    mappings.put(neighbor, new Node(neighbor.val));
                    // add into queue for next visit
                    queue.offer(neighbor);
                }
               
                // add copy of the neighbor to the copy of current node
                mappings.get(curr).neighbors.add(mappings.get(neighbor));
                
            }
        }
        return mappings.get(node);
    }
}
