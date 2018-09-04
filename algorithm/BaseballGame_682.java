package Amazon20180831;

import java.util.Stack;

public class BaseballGame_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for (int score : stack) ans += score;
        return ans;
    }
    //Time Complexity: O(N)O(N), where NN is the length of ops.
    //We parse through every element in the given array once, and do O(1)O(1) work for each element.
    //
    //Space Complexity: O(N)O(N), the space used to store our stack.
}
