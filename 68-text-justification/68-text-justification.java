class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            StringBuilder sb = new StringBuilder(); // reset StringBuilder if the last line has filled
            int wordCount = 0; // number of words in the current line
            int charNumber = 0; // number of characters that are not spaces
            while (index < words.length && sb.length() + words[index].length() <= maxWidth) {
                sb.append(words[index]);
                charNumber += words[index].length();
                sb.append(" "); // add a space right after appending a word
                index++;
                wordCount++;
            }
            sb.deleteCharAt(sb.length() - 1); // remove the last space
            if (sb.length() < maxWidth) { // if maxWidth has not achieved
                if (wordCount == 1 || index == words.length) { // if current line can fit only one word or it is the last line
                    while (sb.length() < maxWidth) { // simply add more space at the end until achieve maxWidth
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                } else if ((maxWidth - charNumber) % (wordCount - 1) == 0 && index < words.length) { // if space can be evenly divided and the line is not the last line
                    int spaceLen = (maxWidth - charNumber) / (wordCount - 1);
                    String space = generateSpace(spaceLen);
                    String outcome = sb.toString().replaceAll(" ", space); // replace all single space with new space string with the same-length space string
                    res.add(outcome);
                } else if ((maxWidth - charNumber) % (wordCount - 1) != 0 && index < words.length) { // if the space cannot be evenly divided and the line is not the last line
                    String[] ws = sb.toString().split(" "); // need to extract words out to easily manipulate StringBuilder with different lengths of space strings
                    int wsLen = ws.length;
                    StringBuilder newSB = new StringBuilder();
                    // number of excess length that needs to be distributed differentially
                    int currDiff = maxWidth - charNumber;
                    int spaceCount = wordCount - 1;
                    // the TRICK: is to traverse backwards, using greedy method, to assign smaller space and then assign larger space, from right to left, and we need to assert string at the front, instead of appending
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
                    res.add(newSB.toString());
                }
            } else { // the string perfectly fits the maxWidth, as separated by single space
                res.add(sb.toString());
            }
        }
        return res;
    }
    
    // helper function to generate different lengths of space strings as required
    private String generateSpace(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}