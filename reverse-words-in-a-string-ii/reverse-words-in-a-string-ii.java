class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n - 1);
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == ' ' && left == 0 && right == 0) {
                right = i;
                reverse(s, left, right - 1);
            } else if (c == ' ' && right != 0) {
                left = right;
                right = i;
                reverse(s, left + 1, right - 1);
            }
        }
        
        if (left == 0 && right == 0) {
            reverse(s, 0, n - 1);
            return;
        }
        
        reverse(s, right + 1, n - 1);

    }
    
    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}