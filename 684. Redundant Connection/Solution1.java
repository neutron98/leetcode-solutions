
// DFS
// Time: O(N^2) . N is numer of edges
// Space: O(N)

class Solution1 {
    List<List<Integer>> graph = new ArrayList<>(1001);
    
    public int[] findRedundantConnection(int[][] edges) {
        // corner case
        int[] result = new int[2];
        if (edges.length == 0 || edges[0].length == 0){
            return result;
        }
        
        int e = edges.length;
        for (int i = 0; i < e + 1; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge: edges){
            int u = edge[0], v = edge[1];
            if (duplicated(u, v, 0)){
                result = edge;
            } else{
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        
        return result;
    }
    
    
    // check if a connection is duplicated
    private boolean duplicated(int source, int target, int parent){
        if (source == target){
            return true;
        }
        
        for (int neighbor: graph.get(source)){ // for each of neighbor
            if (neighbor == parent){  // trivial cycle
                continue;
            }
            if (duplicated(neighbor, target, source)){  
                // if its neighbor is already connected with x
                return true;
            }
        }
        return false;
    }
}
