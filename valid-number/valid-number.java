class Solution {
    public boolean isNumber(String s) {
        boolean sign = false;
        boolean letter = false;
        boolean dot = false;
        boolean digit = false;
                
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                digit = true;
            }
            else if (curr == '+' || curr == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (curr == 'e' || curr == 'E') {
                if (letter || !digit) {
                    return false;
                }
                letter = true;
                digit = false;
            }
            else if (curr == '.') {
                if (dot || letter) {
                    return false;
                }
                dot = true;
            }
            else {
                return false;
            }
        }
        return digit;
    }
}