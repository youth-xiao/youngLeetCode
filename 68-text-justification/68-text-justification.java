class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            StringBuilder sb = new StringBuilder();
            int wordCount = 0;
            int charNumber = 0;
            while (index < words.length && sb.length() + words[index].length() <= maxWidth) {
                sb.append(words[index]);
                charNumber += words[index].length();
                sb.append(" ");
                index++;
                wordCount++;
            }
            sb.deleteCharAt(sb.length() - 1); // remove the last space
            if (sb.length() < maxWidth) {
                if (wordCount == 1) {
                        int rightSpaceLen = maxWidth - sb.length();
                        for (int i = 0; i < rightSpaceLen; i++) {
                            sb.append(" ");
                        }
                        String outcome = sb.toString();
                        res.add(outcome);
                } else if ((maxWidth - charNumber) % (wordCount - 1) == 0 && index < words.length) {
                    int spaceLen = (maxWidth - charNumber) / (wordCount - 1);
                    String space = generateSpace(spaceLen);
                    String outcome = sb.toString().replaceAll(" ", space);
                    res.add(outcome);
                } else if ((maxWidth - charNumber) % (wordCount - 1) != 0 && index < words.length) {
                    /*
                    own reason for (3 + 6 + 3 = 12)
                    maxWidth = 17
                    (17 - 12) = 5
                    3 words
                    2 spaces
                    
                    5 / 2 = 2
                    (5 - 2) / (2 - 1)
                    
                    5 / 2 = 2
                    3 / 1 = 3
                    
                    
                    what you can do (4+3+3+2 = 12)
                    maxWidth = 16
                    16 - 12 = 4
                    4 words, 3 spaces
                    2, 1, 1
                    4 / 3 = 1
                    3 / 2 = 1
                    2 / 1 = 2
                    
                    */
                    
                    String[] ws = sb.toString().split(" ");
                    int wsLen = ws.length;
                    StringBuilder newSB = new StringBuilder();
                    
                    int currDiff = maxWidth - charNumber;
                    int spaceCount = wordCount - 1;
                    int wsIndex = wsLen - 1;
                    while (spaceCount > 0) {
                        int spaceLen = currDiff / spaceCount;
                        String space = generateSpace(spaceLen);
                        newSB.insert(0, ws[wsIndex]);
                        newSB.insert(0, space);
                        currDiff -= spaceLen;
                        spaceCount--;
                        wsIndex--;
                    }
                    newSB.insert(0, ws[0]);
                    
//                     int smallSpace = (maxWidth - charNumber) / (wordCount - 1);
//                     int largeSpace = (maxWidth - charNumber - smallSpace) / (wordCount - 2);
                    
                    
//                     String largeSpaceStr = generateSpace(largeSpace);
//                     String smallSpaceStr = generateSpace(smallSpace);
//                     for (int i = 0; i < wsLen - 2; i++) {
//                         newSB.append(ws[i]).append(largeSpaceStr);
//                     }
//                     newSB.append(ws[wsLen - 2]).append(smallSpaceStr).append(ws[wsLen - 1]);
                    res.add(newSB.toString());
                }
                else if (index == words.length) {
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                }
            } else {
                res.add(sb.toString());
            }
        }
        
        return res;
    }
    
    private String generateSpace(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}