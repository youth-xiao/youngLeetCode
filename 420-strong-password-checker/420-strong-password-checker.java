class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        char[] chars = password.toCharArray();
        int lower = 0, upper = 0, digit = 0;
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') lower = 1;
            else if (c >= 'A' && c <= 'Z') upper = 1;
            else if (c >= '0' && c <= '9') digit = 1;
        }
        int types = lower + upper + digit;
        if (n < 6) {
            return Math.max(6 - n, 3 - types);
        } else if (n <= 20) {
            int ans = 0;
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && chars[j] == chars[i]) {
                    j++;
                }
                int count = j - i;
                if (count >= 3) {
                    ans += count / 3;
                }
                i = j;
            }
            return Math.max(ans, 3 - types);
        } else {
            int ans = 0;
            int[] counts = new int[3];
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && chars[j] == chars[i]) {
                    j++;
                }
                int count = j - i;
                if (count >= 3) {
                    ans += count / 3;
                    counts[count % 3]++;
                }
                i = j;
            }
            int base = n - 20, curr = base;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    counts[i] = ans;
                }
                if (counts[i] != 0 && curr != 0) {
                    int t = Math.min(counts[i] * (i + 1), curr);
                    curr -= t;
                    ans -= t / (i + 1);
                }
            }
            return base + Math.max(ans, 3 - types);
        }
    }
    
}