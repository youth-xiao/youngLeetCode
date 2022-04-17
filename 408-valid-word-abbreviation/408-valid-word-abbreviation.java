class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordLen = word.length();
        int abbrLen = abbr.length();
        
        int i = 0; // index for String word
        int j = 0; // index for String abbr
        
        while (i < wordLen && j < abbrLen) {
            if (word.charAt(i) != abbr.charAt(j)) { // this situation is only allowed when digits occur in 'abbr'
                if (!Character.isDigit(abbr.charAt(j))) {
                    return false;
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (j < abbrLen && Character.isDigit(abbr.charAt(j))) {
                        sb.append(abbr.charAt(j));
                        j++;
                    }
                    if (sb.charAt(0) == '0') return false;
                    int shift = Integer.parseInt(sb.toString());
                    i += shift;
                }
                
            } else {
                i++;
                j++;
            }
        }
        return i == wordLen && j == abbrLen;
    }
}


// class Solution {
//     public boolean validWordAbbreviation(String word, String abbr) {
//         int len = word.length();
//         int abbrLen = abbr.length();
//         int i = 0;
//         int currLen = 0;
//         while (i < abbrLen) {
//             char c = word.charAt(i);
//             if (Character.isDigit(c)) {
//                 if (c == '0') {
//                     return false;
//                 } else {
//                     int num = 0;
//                     char digit = word.charAt(i);
//                     while (Character.isDigit(digit)) {
//                         num = (num * 10) + (digit - '0');
//                         i++;
//                     }
//                     if (num > len) {
//                         return false;
//                     } else {
//                         currLen += num;
//                     }
//                 }
//             } else {
//                 currLen++;
//             }
//         }
//         return currLen == len;
//     }
// }