class Solution {
    
    Map<Integer, Integer> memoMap = new HashMap<>();
    
    public int numDecodings(String s) {
        return decodeRecur(0, s);
    }
    
    public int decodeRecur(int index, String str) {
        if (memoMap.containsKey(index)) {
            return memoMap.get(index);
        }
        
        if (index == str.length()) {
            return 1;
        }
        
        if (str.charAt(index) == '0') {
            return 0;
        }
        
        if (index == str.length() - 1) {
            return 1;
        }
        
        int ans = decodeRecur(index + 1, str);
        
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += decodeRecur(index + 2, str);
        }
        
        memoMap.put(index, ans);
        
        return ans;
     }
}