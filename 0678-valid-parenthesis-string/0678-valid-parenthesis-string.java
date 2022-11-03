class Solution {
    public boolean checkValidString(String s) {
        // NOTE: stacks to store index, NOT char
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // see left (, just push
            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') { // see *, just push, because it can be anything
                star.push(i);
            } else { // see right ), need to check a few things
                // if nothing left in both stacks: nothing to match with )
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                }
                // pop left stack (higher priority)
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) { // we only use * when there is no left ( available to use
                    star.pop();
                }
            }
        }
        // need to see if left ( comes before *
        while (!left.isEmpty() && !star.isEmpty()) {
            // in this case, the order would be: * ( => )(, or ((, or (, none of those have matches
            if (left.pop() > star.pop()) {
                return false;
            }
        }
        return left.isEmpty(); // if all parenthesis match, the ( in left stack should be all used up for matching, it is ok to leave star stack non-empty, because * can be ''
    }
}