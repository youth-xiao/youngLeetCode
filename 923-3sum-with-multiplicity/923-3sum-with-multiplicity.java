class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        long[] count = new long[101];
        for (int i : arr) count[i]++;
        
        long ans = 0;
        
        // i != j != k
        for (int i = 0; i <= 100; i++) {
            for (int j = i + 1; j <= 100; j++) { // i and j are always different in this section
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
            if (target % 2 == i % 2) { // this means either both target and i are even numbers, or both target and i are odd numbers, only in this way j and k can be equal, otherwise, target - i would be an odd number which cannot be evenly divided by 2
                int j = (target - i) / 2;
                if (i < j && j <= 100) {
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                    ans %= MOD;
                }
            }
        }
        
        // i == j == k
        if (target % 3 == 0) { // this means that target can be evenly divided by 3
            int i = target / 3;
            if (0 <= i && i <= 100) {
                ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6; // 6: refer to binomial
                ans %= MOD;
            }
        }
        
        return (int) ans;
    }
}