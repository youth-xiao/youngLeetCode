class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int len = chars.length;
        int index = 0;
        int left = 0;
        
        while (left < len) {
            char c = chars[left];
            int right = left;
            while (right < len && chars[left] == chars[right]) {
                right++;
            }
            int freq = right - left;
            chars[index] = c;
            index++;
            
            if (freq == 1) {
                
            } else if (freq < 10) {
                chars[index] = (char)(freq + '0');
                index++;
            } else {
                String freqString = String.valueOf(freq);
                for (char ch : freqString.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
            left = right;
        }
        
        return index;
    }
}



// class Solution {
//     public int compress(char[] chars) {
//         int left = 0;
//         int right = 0;
//         int len = chars.length;
//         while (right < len) {
//             if (chars[left] == chars[right]) {
//                 chars[right] = '*';
//                 right++;
//             } else {
//                 int number = right - left;
//                 if (number == 1) {
                    
//                 } else if (number < 10) {
//                     chars[right - 1] = (char) (number);
//                 } else {
//                     // 12 -> 2, 1
//                     int index = right - 1;
//                     while (number > 0 && index > 0) {
//                         int digit = number % 10;
//                         chars[index--] = (char) (digit);
//                         number /= 10;
//                     }
//                 }
//                 left = right;
//             }
//         }
        
//         int newLength = 0;
//         for (char c : chars) {
//             if (c != '*') {
//                 newLength++;
//             }
//         }
        
//         return newLength;
//     }
// }