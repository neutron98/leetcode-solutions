class Solution {
    // undirected + directed graph
    int count = 0;
    // O(E + V)
    // O(E + V)
    public int minReorder(int n, int[][] connections) {
        // If the edge is in forward direction in the Directed graph, then we count this edge.
        List<List<Integer>> undirected = new ArrayList<>();
        List<Set<Integer>> directed = new ArrayList<>();
        for (int i = 0; i < n; i++){
            undirected.add(new ArrayList<>());
            directed.add(new HashSet<>());
        }
        
        for (int[] pair: connections){
            undirected.get(pair[0]).add(pair[1]);   
            undirected.get(pair[1]).add(pair[0]); 
            
            directed.get(pair[0]).add(pair[1]);
        }
        // dfs(0)
        //  |_____ dfs(1) + count(from 0 to 1)  + dfs(4) + count(from 1 to 4)
        // 
        boolean[] visited = new boolean[n];
        dfs(undirected, directed, visited, 0);
        return count;
    }
    
    private void dfs(List<List<Integer>> undirected, List<Set<Integer>> directed , boolean[] visited, int node){
        visited[node] = true;
        for (int child: undirected.get(node)){
            if (visited[child]){
                continue;
            }
            
            if (directed.get(node).contains(child)){
                count += 1;
            }
            dfs(undirected,directed,visited, child);
        }
    }
}
