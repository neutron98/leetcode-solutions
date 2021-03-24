class SnakeGame {
    /**
        1. How to represent the sname? Matrix is impossible - use deque
        2. How to move the snake? remove the tail and add new head
        3. How to grow size? add tail
        4. How to check the snake bits itself? Check if the new head is part of the body.
    */
    private static class Cell{
        int row;
        int col;
        Cell(int r, int c){
            this.row = r;
            this.col = c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
        
        @Override
        public boolean equals(Object o){
            if (!(o instanceof Cell)){
                return false;
            }
            
            Cell c = (Cell) o;
            if (c == this){
                return true;
            }
            
            return c.row == this.row && c.col == this.col;
        }
    }
    
    
    private Map<Cell, Boolean> snakeMap;
    private Deque<Cell> snake;
    private int[][] food;
    private int foodIndex;
    private int width;
    private int height;

    /**
     * Initialize your data structure here.
     *
     * @param width - screen width
     * @param height - screen height
     * @param food - A list of food positions E.g food = [[1,1], [1,0]] means the first food is
     *     positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = new HashMap<>();
        this.snakeMap.put(new Cell(0,0), true); // intially at [0][0]
        this.snake = new LinkedList<>();
        this.snake.offerLast(new Cell(0,0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over. Game over when snake crosses
     *     the screen boundary or bites its body.
     */
    public int move(String direction) {

        Cell snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.row;
        int newHeadColumn = snakeCell.col;

        switch (direction) {
        case "U":
            newHeadRow--;
            break;
        case "D":
            newHeadRow++;
            break;
        case "L":
            newHeadColumn--;
            break;
        case "R":
            newHeadColumn++;
            break;
        }

        Cell newHead = new Cell(newHeadRow, newHeadColumn);
        Cell currentTail = this.snake.peekLast();

        // Boundary conditions.
        if (!inBound(newHead)){
            return -1;
        }

        // Checking if the snake bites itself.
        if (biteItself(newHead, currentTail)){
            return -1;
        }

        eatFood(newHead, currentTail);

        // A new head always gets added
        this.snake.addFirst(newHead);

        // Also add the head to the set
        this.snakeMap.put(newHead, true);
        
        return this.snake.size() - 1;
    }
    
    private boolean inBound(Cell c){
        return c.row >= 0 && c.row < this.height 
            && c.col >= 0 && c.col < this.width;
    }
    
    private boolean biteItself(Cell newHead, Cell currentTail){
        return this.snakeMap.containsKey(newHead) && 
            !(newHead.row == currentTail.row && newHead.col == currentTail.col);
    }
    
    private void eatFood(Cell newHead, Cell currentTail){
        // If there's an available food item and it is on the cell occupied by the snake after the move,
        // eat it.
        if ((this.foodIndex < this.food.length)
            && (this.food[this.foodIndex][0] == newHead.row)
            && (this.food[this.foodIndex][1] == newHead.col)) {
            this.foodIndex++;
        } else {
            this.snake.pollLast();
            this.snakeMap.remove(currentTail);
        }
        
    }
    
}

/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj = new
 * SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */
