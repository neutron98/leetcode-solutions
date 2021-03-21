// G is fully connected.
// G contains no cycles.

// DFS
// Time: O(N+E)
// Space: O(N+E)

class Solution1 {
    public boolean validTree(int n, int[][] edges) {
        // No cycles
        if (edges.length != n - 1){
            return false;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        // add neighbor nodes
        for (int[] edge: edges){
            int p = edge[0];
            int q = edge[1];
            graph.get(p).add(q);
            graph.get(q).add(p);
        }
        
        // traverse
        /*
              1
            /   \
           2  -  3  
          /
         4
           
        */
        
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        // starter node
        stack.push(0);
        seen.add(0);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for (int neighbor: graph.get(node)){
                if (seen.contains(neighbor)){  // visited
                    continue;
                }
                stack.push(neighbor);
                seen.add(neighbor);
            }
        }
        // "fully connected?"
        return seen.size() == n;
    }
}
