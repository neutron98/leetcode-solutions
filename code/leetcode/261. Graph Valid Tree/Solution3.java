// Union find
class Solution3 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1){
            return false;
        }
        
        DSU dsu = new DSU(n);
        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if (!dsu.union(x, y)){  // if the union fails, there is a cycle
                return false;
            }
        }
        return true;
    }
}


class DSU{
    private int[] parent;
    private int[] rank;
    
    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
   public int find(int x){
        if (parent[x] != x){  // while x is not its own parent
            parent[x] = find(parent[x]);  // path compression
        }
        // set each node directly (possible optimization)
        return parent[x];
    }
/*
    public int find(int x){
        int root = x;
        while (parent[root] != root){  // while x is not its own parent
            root = parent[root];  // visit its parent
        }
        // set each node directly (possible optimization)
        
        while (x != root){
            int oldRoot = parent[x];
            parent[x] = root;
            x = oldRoot;
        }
        return root;
    }
*/
    
    public boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY){
            return false;
        }
        if (rank[parentX] > rank[parentY]){
            parent[parentY] = parentX;
            rank[parentX] += rank[parentY];
        } else{
            parent[parentX] = parentY;
            rank[parentY] += rank[parentX];
        }
        
        return true;
    }
}
