class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (int i = 0; i < len1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(map1, map2)) return true;
        
        for (int i = len1; i < len2; i++) {
            map2[s2.charAt(i) - 'a']++;
            map2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(map1, map2)) return true;
        }
        
        return false;
    }
}