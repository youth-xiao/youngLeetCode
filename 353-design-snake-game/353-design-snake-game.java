class SnakeGame {
    HashSet<Pair<Integer, Integer>> snakeSet;
    // HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
    Deque<Pair<Integer, Integer>> snake;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        // this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();
        this.snakeSet = new HashSet<>();
        snakeSet.add(new Pair<Integer, Integer>(0, 0));
        // snakeMap.put(new Pair<Integer, Integer>(0, 0), true); // (0, 0) initial position
        this.snake = new LinkedList<Pair<Integer, Integer>>();
        this.snake.offerLast(new Pair<Integer, Integer>(0, 0));
    }
    
    public int move(String direction) {
        Pair<Integer, Integer> snakeCell = this.snake.peekFirst(); // the head
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
        
        Pair<Integer, Integer> newHead = 
            new Pair<Integer, Integer>(newHeadRow, newHeadColumn);
        
        Pair<Integer, Integer> currTail = this.snake.peekLast();
        
        boolean crossBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
        boolean crossBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;
        
        boolean bitesItself = this.snakeSet.contains(newHead) 
            && !(newHead.getKey() == currTail.getKey() && newHead.getValue() == currTail.getValue()); // the current tail is NOT a part of the snake's body.
        // case 1: this move does not eat a food, the current tail will be updated, to become void
        // case 2: this move is to eat a food, the food cannot appear at the location where the snake cells are
        
        if (crossBoundary1 || crossBoundary2 || bitesItself) return -1;
        
        // this is a move to get food
        if ((this.foodIndex < this.food.length)
           && (this.food[this.foodIndex][0] == newHeadRow)
           && (this.food[this.foodIndex][1] == newHeadColumn)) {
            this.foodIndex++;
        } else { // this move does not get food
            // update tail
            this.snake.pollLast();
            this.snakeSet.remove(currTail);
        }
        
        // add new head
        this.snake.addFirst(newHead);
        this.snakeSet.add(newHead);
        
        return this.snake.size() - 1; // because we start with length of 1, without eating any food
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */


// class SnakeGame {
    
//     HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
//     Deque<Pair<Integer, Integer>> snake;
//     int[][] food;
//     int foodIndex;
//     int width;
//     int height;

//     public SnakeGame(int width, int height, int[][] food) {
//         this.width = width;
//         this.height = height;
//         this.food = food;
//         this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();
//         snakeMap.put(new Pair<Integer, Integer>(0, 0), true); // (0, 0) initial position
//         this.snake = new LinkedList<Pair<Integer, Integer>>();
//         this.snake.offerLast(new Pair<Integer, Integer>(0, 0));
//     }
    
//     public int move(String direction) {
//         Pair<Integer, Integer> snakeCell = this.snake.peekFirst(); // the head
//         int newHeadRow = snakeCell.getKey();
//         int newHeadColumn = snakeCell.getValue();
        
//         switch (direction) {
//             case "U":
//                 newHeadRow--;
//                 break;
//             case "D":
//                 newHeadRow++;
//                 break;
//             case "L":
//                 newHeadColumn--;
//                 break;
//             case "R":
//                 newHeadColumn++;
//                 break;
//         }
        
//         Pair<Integer, Integer> newHead = 
//             new Pair<Integer, Integer>(newHeadRow, newHeadColumn);
        
//         Pair<Integer, Integer> currTail = this.snake.peekLast();
        
//         boolean crossBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
//         boolean crossBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;
        
//         boolean bitesItself = this.snakeMap.containsKey(newHead) 
//             && !(newHead.getKey() == currTail.getKey() && newHead.getValue() == currTail.getValue()); // the current tail is NOT a part of the snake's body.
//         // case 1: this move does not eat a food, the current tail will be updated, to become void
//         // case 2: this move is to eat a food, the food cannot appear at the location where the snake cells are
        
//         if (crossBoundary1 || crossBoundary2 || bitesItself) return -1;
        
//         // this is a move to get food
//         if ((this.foodIndex < this.food.length)
//            && (this.food[this.foodIndex][0] == newHeadRow)
//            && (this.food[this.foodIndex][1] == newHeadColumn)) {
//             this.foodIndex++;
//         } else { // this move does not get food
//             // update tail
//             this.snake.pollLast();
//             this.snakeMap.remove(currTail);
//         }
        
//         // add new head
//         this.snake.addFirst(newHead);
//         this.snakeMap.put(newHead, true);
        
//         return this.snake.size() - 1; // because we start with length of 1, without eating any food
//     }
// }

// /**
//  * Your SnakeGame object will be instantiated and called as such:
//  * SnakeGame obj = new SnakeGame(width, height, food);
//  * int param_1 = obj.move(direction);
//  */