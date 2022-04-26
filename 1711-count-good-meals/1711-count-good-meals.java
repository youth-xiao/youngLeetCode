class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        int floor = maxVal * 2;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= floor; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}


// class Solution { // TLE
//     public int countPairs(int[] deliciousness) {
//         int n = deliciousness.length;
//         int count = 0;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int sum = deliciousness[i] + deliciousness[j];
//                 if (powerOfTwo(sum)) {
//                     count++;   
//                 }
//             }
//         }
//         return count;
//     }
    
//     private boolean powerOfTwo(int sum) {
//         if (sum == 0) {
//             return false;
//         }
//         while (sum != 1) {
//             if (sum % 2 != 0) {
//                 return false;
//             }
//             sum /= 2;
//         }
//         return true;
//     }
// }