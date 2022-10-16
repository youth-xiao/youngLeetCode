class StockSpanner {

    Stack<Integer> prices;
    Stack<Integer> weights;
    
    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }
    
    public int next(int price) {
        int w = 1; // 每一轮 w都会被重置为1
        // prices与weights同时进退，所以prices的元素与其对应的weights的位置是一样的
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */