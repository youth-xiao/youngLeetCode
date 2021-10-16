class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int lo = 0, hi = i;
            while (lo < hi - 1) {
                int mid = lo + (hi - lo) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    lo = mid;
                }
                else {
                    hi = mid;
                }
            }
            dp[i + 1] = Math.max(dp[i + 1], (jobs[lo][1] <= jobs[i][0] ? dp[lo + 1] : 0) + jobs[i][2]);
        }
        return dp[n];
    }
}