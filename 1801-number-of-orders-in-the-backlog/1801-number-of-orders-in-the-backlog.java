class Order implements Comparable<Order> {
    int price;
    int amount;
    int type;
    
    Order(int price, int amount, int type) {
        this.price = price;
        this.amount = amount;
        this.type = type;
    }
    
    @Override
    public int compareTo(Order order) {
        return this.price - order.price;
    }
}

class Solution {
    private static final int BUY = 0;
    private static final int SELL = 1;
    private static final int MOD = 1000000007;
    
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Order> sellBacklog = new PriorityQueue<>();
        PriorityQueue<Order> buyBacklog = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            Order o = new Order(price, amount, type);
            if (type == SELL) {
                Order topBuy = buyBacklog.peek();
                // topBuy == null means buyBacklog is empty; o.amount > 0 means the requested amount has not been filled/satisfied
                while (topBuy != null && topBuy.price >= o.price && o.amount > 0) {
                    int topBuyRemain = Math.max(topBuy.amount - o.amount, 0);
                    int oRemain = Math.max(o.amount - topBuy.amount, 0);
                    topBuy.amount = topBuyRemain;
                    if (topBuyRemain == 0) {
                        buyBacklog.poll(); // remoave any order with zero amount -> rearrange priority
                    }
                    o.amount = oRemain;
                    topBuy = buyBacklog.peek();
                }
                if (o.amount > 0) { // buyBacklog has been emptied but o.amount still > 0
                    sellBacklog.add(o);
                }
            } else { // type == BUY
                Order topSell = sellBacklog.peek();
                while (topSell != null && topSell.price <= o.price && o.amount > 0) {
                    int topSellRemain = Math.max(topSell.amount - o.amount, 0);
                    int oRemain = Math.max(o.amount - topSell.amount, 0);
                    topSell.amount = topSellRemain;
                    if (topSellRemain == 0) {
                        sellBacklog.poll();
                    }
                    o.amount = oRemain;
                    topSell = sellBacklog.peek();
                }
                if (o.amount > 0) {
                    buyBacklog.add(o);
                }
            }
        }
        
        int total = 0;
        while (!sellBacklog.isEmpty()) {
            Order sell = sellBacklog.poll();
            total = (total + sell.amount) % MOD;
        }
        while (!buyBacklog.isEmpty()) {
            Order buy = buyBacklog.poll();
            total = (total + buy.amount) % MOD;
        }
        return total;
    }
}