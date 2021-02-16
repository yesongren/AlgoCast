package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2021/02/16
 * 155. Min Stack
 */
public class P017_MinStack {
    /** initialize your data structure here. */
    Deque<Integer> stack;
    Deque<Integer> min;

    public P017_MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        // (min.isEmpty() || x <= min.peek());
        if (min.isEmpty() || x <= getMin()) min.push(x);
    }

    public void pop() {
        if (stack.peek() == getMin()) min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
