class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // eliminate possible duplicates
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) { // if wordSet doesn't contain endWord, no need to find the ladder at all
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); // this queue is for BFS
        queue.add(beginWord);
        Set<String> visited = new HashSet<>(); // use visited set to avoid repeating same steps and avoid TLE
        visited.add(beginWord);
        
        int steps = 1; // including beginWord itself
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord = queue.poll();
                if (changeOneLetter(currWord, endWord, wordSet, visited, queue)) { // reached the endWord
                    return steps + 1;
                }
            }
            steps++;
        }
        return 0;
    }
    
    private boolean changeOneLetter(String currWord, String endWord, Set<String> wordSet, Set<String> visited, Queue<String> queue) {
        char[] wordArray = currWord.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char oldChar = wordArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == oldChar) continue; // don't need to do replacement for the same char
                wordArray[i] = k;
                String newWord = String.valueOf(wordArray);
                if (wordSet.contains(newWord)) { // check this condition first of all
                    if (newWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) { // also need to remember check this before adding, otherwise TLE
                        queue.add(newWord);
                        visited.add(newWord);
                    }
                }
            }
            wordArray[i] = oldChar; // backtracking
        }
        return false;
    }
}