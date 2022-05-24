class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        long[] count = new long[101];
        for (int i : arr) count[i]++;
        
        long ans = 0;
        
        // i != j != k
        for (int i = 0; i <= 100; i++) {
            for (int j = i + 1; j <= 100; j++) {
                int k = target - i - j;
                if (j < k && k <= 100) {
                    ans += count[i] * count[j] * count[k];
                    ans %= MOD;
                }
            }
        }
        
        // i == j != k
        for (int i = 0; i <= 100; i++) {
            int k = target - 2 * i;
            if (i < k && k <= 100) {
                ans += count[i] * (count[i] - 1) / 2 * count[k];
                ans %= MOD;
            }
        }
        
        // i != j == k
        for (int i = 0; i <= 100; i++) {
            if (target % 2 == i % 2) {
                int j = (target - i) / 2;
                if (i < j && j <= 100) {
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                    ans %= MOD;
                }
            }
        }
        
        // i == j == k
        if (target % 3 == 0) {
            int i = target / 3;
            if (0 <= i && i <= 100) {
                ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                ans %= MOD;
            }
        }
        
        return (int) ans;
    }
}