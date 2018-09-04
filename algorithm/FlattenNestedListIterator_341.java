package HighFrequence.Summary;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 {
    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            flattenList(nestedList);
        }

        @Override
        public Integer next() {
            return hasNext() ? stack.pop().getInteger() : null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) return true;
                flattenList(stack.pop().getList());
            }
            return false;
        }

        private void flattenList(List<NestedInteger> list) {
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
    }

    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

}
