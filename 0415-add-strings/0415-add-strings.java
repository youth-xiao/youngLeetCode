class Solution {
    // public String addStrings(String num1, String num2) {
    //     StringBuilder res = new StringBuilder();
    //     int p1 = num1.length() - 1;
    //     int p2 = num2.length() - 1;
    //     int carry = 0;
    //     while (p1 >= 0 || p2 >= 0) {
    //         int v1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
    //         int v2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
    //         int value = (v1 + v2 + carry) % 10;
    //         carry = (v1 + v2 + carry) / 10;
    //         res.append(value);
    //         p1--;
    //         p2--;
    //     }
    //     if (carry > 0) {
    //         res.append(carry);
    //     }
    //     return res.reverse().toString();
    // }
    
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int n1 = 0;
            if (len1 >= 0) {
                n1 = num1.charAt(len1) - '0';
            }
            int n2 = 0;
            if (len2 >= 0) {
                n2 = num2.charAt(len2) - '0';
            }
            int value = (n1 + n2 + carry) % 10;;
            carry = (n1 + n2 + carry) / 10;
            sb.insert(0, value);
            len1--;
            len2--;
        }
        
        if (carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}