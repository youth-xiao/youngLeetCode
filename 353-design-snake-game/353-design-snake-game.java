class SnakeGame {
    
    HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
    Deque<Pair<Integer, Integer>> snake;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();
        snakeMap.put(new Pair<Integer, Integer>(0, 0), true);
        this.snake = new LinkedList<Pair<Integer, Integer>>();
        this.snake.offerLast(new Pair<Integer, Integer>(0, 0));
    }
    
    public int move(String direction) {
        Pair<Integer, Integer> snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.getKey();
        int newHeadColumn = snakeCell.getValue();
        
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
        
        Pair<Integer, Integer> newHead = new Pair<Integer, Integer>(newHeadRow, newHeadColumn);
        Pair<Integer, Integer> currTail = this.snake.peekLast();
        
        boolean crossBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
        boolean crossBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;
        boolean bitesItself = this.snakeMap.containsKey(newHead) && !(newHead.getKey() == currTail.getKey() && newHead.getValue() == currTail.getValue());
        
        if (crossBoundary1 || crossBoundary2 || bitesItself) return -1;
        
        if ((this.foodIndex < this.food.length)
           && (this.food[this.foodIndex][0] == newHeadRow)
           && (this.food[this.foodIndex][1] == newHeadColumn)) {
            this.foodIndex++;
        } else {
            this.snake.pollLast();
            this.snakeMap.remove(currTail);
        }
        
        this.snake.addFirst(newHead);
        this.snakeMap.put(newHead, true);
        
        return this.snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */