class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]))
        );
        
        for (int[] point : points) {
            pq.add(point);
        }
        
        int[][] res = new int[k][2];
        int i = 0;
        while (k > 0) {
            int[] curr = pq.poll();
            res[i] = curr;
            i++;
            k--;
        }
        
        return res;
    }
}