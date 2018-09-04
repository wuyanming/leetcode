package Amazon20180831;

import java.util.Stack;

public class MinStack_155 {
    static class Element {
        final int value;
        final int min;

        Element(final int value, final int min) {
            this.value = value;
            this.min = min;
        }
    }

    final Stack<Element> stack = new Stack<>();

    public void push(int x) {
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        stack.push(new Element(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }


    public class MinStack_Second {
        long min;
        Stack<Long> stack;

        public MinStack_Second() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = x;
            } else {
                stack.push(x - min);//Could be negative if min value needs to change
                if (x < min) min = x;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            long pop = stack.pop();

            if (pop < 0) min = min - pop;//If negative, increase the min value

        }

        public int top() {
            long top = stack.peek();
            if (top > 0) {
                return (int) (top + min);
            } else {
                return (int) (min);
            }
        }

        public int getMin() {
            return (int) min;
        }
    }

}
