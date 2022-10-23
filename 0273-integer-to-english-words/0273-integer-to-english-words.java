class Solution {
    
    String[] LESS_THAN_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six",
                                        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                                        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                        "Eighteen", "Nineteen"};
    String[] LESS_THAN_100 = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                                         "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
    
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String answer = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                answer = helper(num % 1000) + THOUSANDS[i] + " " + answer;
            }
            num /= 1000;
            i++;
        }

        return answer.trim();
    }
    
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return LESS_THAN_100[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100); 
        }
        
    }
}