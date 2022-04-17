class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') { // push all open brackets found
                stack.push(c);
            } else { // c == ')'
                if (stack.isEmpty()) { // cannot find match of an open bracket
                    count++;
                } else { // find an open bracket to match, so pop the open bracket
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }
}