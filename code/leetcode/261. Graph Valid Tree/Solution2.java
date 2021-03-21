// G is fully connected.
// G contains no cycles.

// Solution2: BFS
// Time: O(N+E)
// Space: O(N+E)

class Solution2 {
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
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbor: graph.get(node)){
                if (seen.contains(neighbor)){
                    continue;
                }
                seen.add(neighbor);
                queue.offer(neighbor);
            }
        }
        
        return seen.size() == n;
    }

}
