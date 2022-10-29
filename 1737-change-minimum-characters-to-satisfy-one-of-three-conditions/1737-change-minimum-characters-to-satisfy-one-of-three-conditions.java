class Solution {
    public int minCharacters(String a, String b) {
        int[] acount = new int[26];
        int[] bcount = new int[26];
        int an = a.length();
        int bn = b.length();
        
        for (int i = 0; i < an; i++) {
            acount[a.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < bn; i++) {
            bcount[b.charAt(i) - 'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        int asum = 0;
        int bsum = 0;
        
        for (int i = 0; i < 25; i++) {
            asum += acount[i];
            bsum += bcount[i];
            ans = Math.min(
                Math.min(ans, an - acount[i] + bn - bcount[i]),
                Math.min(an - asum + bsum, bn - bsum + asum));
        }
        ans = Math.min(ans, an - acount[25] + bn - bcount[25]);
        return ans;
    }
}