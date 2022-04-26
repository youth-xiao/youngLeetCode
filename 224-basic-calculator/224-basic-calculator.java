class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        String str = s.replaceAll(" ", ""); // remove any space
        Deque<Character> ops = new ArrayDeque<>();
        int n = str.length();
        char[] cs = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') { // just the beginning of one section enclosed by '(' and ')'
                ops.addLast(c);
            } else if (c == ')') { // reached the end of one section
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') { // it means there are '+' and '-' for us to process calculation
                        calculate(nums, ops);
                    } else { // it means we've exhausted all digits and operators within this section
                        ops.pollLast(); // simply poll the '('
                        break; // exit the current section's calculation loop
                    }
                }
            } else { // it is either a digit or operator
                if (Character.isDigit(c)) { // it is a digit
                    int sum = 0;
                    int j = i;
                    // using while loop in case of a number that has more than one digit
                    while (j < n && Character.isDigit(cs[j])) {
                        sum = sum * 10 + (int)(cs[j] - '0');
                        j++;
                    }
                    nums.addLast(sum);
                    i = j - 1; // we cannot simply use i as it is, because if the int has more than one digit, we actually will increment the index by more than 1 within the while looop on line 28, so when we exit the if loop starting from line 24, we will have to skip some indices, because the default for loop starting from line 9, just doing i++
                } else { // it is an operator
                    // i > 0 is used to prevent out of index, since we also use 'i - 1'
                    // this is to treat some specail cases where two operators are together, so we need to insert a 0 in between
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // we want to do as much calculations as possible for the current section before adding a new operator into the stack
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        calculate(nums, ops);
                    }
                    ops.addLast(c); // add the operator after completing some of the calculations
                }
            }
        }
        // we reach here because we have iterated through the string s, and all left is to pop elements and do calculations
        while (!ops.isEmpty()) {
            calculate(nums, ops);
        }
        // the top number in the stack is the final result
        return nums.peekLast();
    }
    
    // helper function to calculate
    private void calculate(Deque<Integer> nums, Deque<Character> ops) {
        // if there is only one number in the nums stack, it means operator stack has been emptied and that is the final answer
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        if (op == '+') {
            nums.addLast(a + b);
        } else {
            nums.addLast(a - b);
        }
    }
}

// class Solution {
//     public int calculate(String s) {
//         Stack<Character> stack = new Stack<>();
//         int res = 0;
//         int i = 0;
//         while (i < s.length()) {
//             char c = s.charAt(i);
//             if (c == '(') {
//                 stack.push(c);
//             } else if (c == ')') {
//                 while (stack.peek() != '(') {
//                     int sum = 0;
//                     if (Character.isDigit(stack.peek())) {
//                         while (Character.isDigit(stack.peek())) {
//                             char curr = stack.pop();
//                             sum = sum * 10 + (curr - '0');
//                         }
//                     } else { // operator
//                         if (c == '+') {
                            
//                         } else if (c == '-') {
                            
//                         }
//                     }
                    
//                 }
//             } else {
//                 stack.push(c);
//             }
//         }
       
//     }
// }