class Solution {
    public int minCharacters(String a, String b) {
        int[] aCount = new int[26];
        int[] bCount = new int[26];
        int an = a.length();
        int bn = b.length();
        
        for (int i = 0; i < an; i++) {
            aCount[a.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < bn; i++) {
            bCount[b.charAt(i) - 'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        int aSum = 0;
        int bSum = 0;
        
        for (int i = 0; i < 25; i++) {
            aSum += aCount[i];
            bSum += bCount[i];
            ans = Math.min(
                Math.min(ans, an - aCount[i] + bn - bCount[i]),
                Math.min(an - aSum + bSum, bn - bSum + aSum));
            /* an - aCount[i] + bn - bCount[i]: make then all identical
            aka: an + bn - aCount[i] - bCount[i]
            the reason for abstraction is that we know that aCount[i] and bCount[i] refer to the same characters, so we don't need to operate on the characters at this index i.
            */
            
            /* an - aSum + bSum:
            aSum at index i: the number of characters that are equal or smaller than the char corresponding at index i
            an - aSum: the number of characters in string a that we want to make them smaller
            bSum: the number of characters in string b that we want to make them bigger
            therefore, we add (an - aSum) and bSum together, which is the total operations that we need to perform on both string a and string b.
            */
                
            // bn - bSum + aSum
        }
        // we need to consider the case 'z' separately, because we can't change z to something larger than 'z'. Since in the previous for loop, we were aimming to change a letter larger than some char
        ans = Math.min(ans, an - aCount[25] + bn - bCount[25]);
        return ans;
    }
}

// class Solution {
//     public int minCharacters(String a, String b) {
//         int[] dic1 = this.dic(a);
//         int[] dic2 = this.dic(b);
//         int[] sums1 = this.sums(dic1);
//         int[] sums2 = this.sums(dic2);
  
//         int ans = Integer.MAX_VALUE;
//         for (int i = 0; i < 25; i++) {
//             // 变成同一个数i
//             int ans1 = sums1[26] - dic1[i] + sums2[26] - dic2[i];
//             // a 小
//             int ans2 = sums1[26] - sums1[i + 1] + sums2[i + 1];
//             // b 小
//             int ans3 = sums2[26] - sums2[i + 1] + sums1[i + 1];
//             ans = Math.min(Math.min(ans2, ans), Math.min(ans1, ans3));
//         }
        
//         ans = Math.min(ans, sums1[26] - dic1[25] + sums2[26] - dic2[25]);
//         return ans;
//     }

//     private int[] sums(int[] dic1) {
//         int[] ans = new int[27];
//         for (int i = 1; i < ans.length; i++) {
//             ans[i] = ans[i - 1] + dic1[i - 1];
//         }
//         return ans;
//     }

//     private int[] dic(String a) {
//         int[] ans = new int[26];
//         for (int i = 0; i < a.length(); i++) {
//             ans[a.charAt(i) - 'a']++;
//         }
//         return ans;
//     }
// }