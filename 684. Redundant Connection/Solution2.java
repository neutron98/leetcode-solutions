// Union Find
// Time: O(N)
// Space: O(N)

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         int size = edges.length + 1;
        DSU dsu = new DSU(size);
        for (int[] edge: edges){
            if (!dsu.union(edge[0], edge[1])){
                return edge;
            }
        }
        
        return new int[2];
    }
}


class DSU {
    int[] parent;
    int[] rank;
    
    // constructor
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    private int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);  // path conpression
        }
        return parent[x];
    }
    
    
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if (px == py){
            return false;
        }
        // union by rank
        
        if (rank[px] > rank[py]){
            parent[py] = px;
            rank[px] += rank[py];
        } else{
            parent[px] = py;
            rank[py] += rank[px];
        }
        return true;
    }
}
