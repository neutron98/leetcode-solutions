class Solution {
    
    int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, 
                        {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    private static class Point{
        int row;
        int col;
        Point(int r, int c){
            this.row = r;
            this.col = c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(this.row, this.col);
        }
        
        @Override
        public boolean equals(Object o){
            if (o == this) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            
            Point p2 = (Point) o;
            return this.row == p2.row && this.col == p2.col;
        }
        @Override
        public String toString(){
            return this.row + "," + this.col;
        }
    }
    public int minKnightMoves(int x, int y) {
        // limit the range of chessboard
        // https://leetcode.jp/leetcode-1197-minimum-knight-moves-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
        if (x == 0 && y == 0){
            return 0;
        }
        int startX = 0, startY = 0;
        
        if (x < 0){
            startX = -x;
            x = 0;
        }
        if (y < 0){
            startY = -y;
            y = 0;
        }
        startX += 2;
        startY += 2;
        x += 2;
        y += 2;
        
        int maxRow = Math.max(startX, x) + 2;
        int maxCol = Math.max(startY, y) + 2;
        
        
        Point origin = new Point(startX, startY);
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        
        queue.offer(origin);
        
        visited.add(origin);
        
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Point p = queue.poll();
                if (p.row == x && p.col == y){
                    return step;
                }
                
                for (int[] dir: directions){
                    int newRow = p.row + dir[0];
                    int newCol = p.col + dir[1];

                    if (newRow < 0 || newRow > maxRow || newCol < 0 || newCol > maxCol){
                        continue;
                    }

                    Point neighbor = new Point(newRow, newCol);
                    if (visited.contains(neighbor)){
                        continue;
                    }

                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
                
            }
            step++;
        }
        
        return step;
    }
}
