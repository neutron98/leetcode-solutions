class Solution {
    // O(mnk)
    class State{
        int r;
        int c;
        int o; // how many obstacles from (0, 0) to (i, j)
        State(int r, int c, int o){
            this.r = r;
            this.c = c;
            this.o = o;
        }
    }
    
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minObstacles = new int[m][n]; // min obstacles from 0 to reach (i, j)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0));
        
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                State s = queue.poll();
                if (s.r == m - 1 && s.c == n - 1){
                    return step;
                }
                
                for (int[] dir: directions){
                    int newR = s.r + dir[0];
                    int newC = s.c + dir[1];
                    if (newR < 0 || newR == m || newC < 0 || newC == n){
                        continue;
                    }
                    int newO = s.o + grid[newR][newC];
                    if (newO >= minObstacles[newR][newC] || newO > k){
                        // 如果走这条路更远，并且障碍更多（更近的路已经更新过了）； 或者到从当前路径这个点的obstacle数量大于可以eliminate的数量
                        // 说明这条路径对我没有帮助
                        continue;
                    }
                    minObstacles[newR][newC] = newO;
                    queue.offer(new State(newR, newC, newO));
                }
            }
            step++;
        }
        return -1;
    }
}
