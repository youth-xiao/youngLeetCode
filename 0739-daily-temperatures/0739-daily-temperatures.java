class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        
        for (int currDay = 0; currDay < len; currDay++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currDay]) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        
        return ans;
    }
}