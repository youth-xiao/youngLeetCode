class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        String str = s.replaceAll(" ", "");
        Deque<Character> ops = new ArrayDeque<>();
        int n = str.length();
        char[] cs = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calculate(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) {
                        u = u * 10 + (int)(cs[j] - '0');
                        j++;
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        calculate(nums, ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            calculate(nums, ops);
        }
        return nums.peekLast();
    }
    
    private void calculate(Deque<Integer> nums, Deque<Character> ops) {
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