class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);
        
        for (int j = 1; j < len; j++) {
            pq.offer(new int[]{0, j});
        }
        
        for (int i = 1; i < k; i++) {
            int[] frac = pq.poll();
            int x = frac[0];
            int y = frac[1];
            if (x + 1 < y) {
                pq.offer(new int[] {x + 1, y});
            }
        }
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
        
    }
}