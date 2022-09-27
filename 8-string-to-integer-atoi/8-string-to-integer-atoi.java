class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int sum = 0;
        int index = 0;
        int len = s.length();
        
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index < len && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < len && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
 
        while (index < len && Character.isDigit(s.charAt(index))) {
            char ch = s.charAt(index);
            int digit = ch - '0';
            if ((sum > Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + digit;
            index++;
        }
        
        return sum * sign;
    }
}