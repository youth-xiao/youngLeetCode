class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int step = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord = queue.poll();
                if (changeOneLetter(currWord, endWord, queue, wordSet, visited)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }
    
    private boolean changeOneLetter(String currWord, String endWord, 
                                    Queue<String> queue, Set<String> wordSet, Set<String> visited) {
        char[] wordArray = currWord.toCharArray();
        for (int i = 0; i < currWord.length(); i++) {
            char oldChar = wordArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == oldChar) { // exclude the same char comparison
                    continue;
                }
                wordArray[i] = k;
                String newWord = String.valueOf(wordArray);
                if (wordSet.contains(newWord)) {
                    if (newWord.equals(endWord)) { // it means it can reach the end
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        queue.add(newWord);
                        visited.add(newWord);
                    }
                }
            }
            wordArray[i] = oldChar; // restore the original word
        }
        return false;
    }
}