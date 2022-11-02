class Solution {
//     public String multiply(String num1, String num2) {
//         if (num1.equals("0") || num2.equals("0")) return "0";
//         String result = "0";
//         for (int j = num2.length() - 1; j >= 0; j--) {
//             int count = num2.charAt(j) - '0';
//             String sum = num1;
//             for (int k = 0; k < count - 1; k++) {
//                 sum = addStrings(sum, num1);
//             }
//             result = addStrings(result, sum);
//         }
//         return result;
//     }
    
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "0";
        int significance = 1;
        for (int j = num2.length() - 1; j >= 0; j--) {
            String single = num2.substring(j, j + 1);
            String currResult = simpleMultiply(single, num1, significance);
            result = addStrings(result, currResult);
            significance++;
        }
        return result;
    }
    
    private String simpleMultiply(String single, String str, int significance) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int total = (str.charAt(i) - '0') * (single.charAt(0) - '0') + carry;
            int value = total % 10;
            carry = total / 10;
            sb.insert(0, value);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        for (int i = 0; i < significance - 1; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
    
    private String addStrings(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (len1 >= 0 || len2 >= 0) {
            int n1 = 0;
            if (len1 >= 0) {
                n1 = s1.charAt(len1) - '0';
            }
            int n2 = 0;
            if (len2 >= 0) {
                n2 = s2.charAt(len2) - '0';
            }
            int total = n1 + n2 + carry;
            int value = total % 10;
            carry = total / 10;
            sb.insert(0, value);
            len1--;
            len2--;
        }
        
        if (carry > 0) {
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
}