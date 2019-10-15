import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    private State lastState;

    enum State {
        PUSH, POP
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        lastState = State.PUSH;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (lastState == State.PUSH) {
            stack1.push(x);
        } else {
            // 如果是刚刚 POP 完的话
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
            lastState = State.PUSH;
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (lastState == State.POP) {
            if (stack2.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stack2.pop();
        } else {
            // 如果是刚刚 PUSH 完的话
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
            lastState = State.POP;
            return stack2.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (lastState == State.POP) {
            if (stack2.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stack2.peek();
        } else {
            // 如果是刚刚 PUSH 完的话
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
            lastState = State.POP;
            return stack2.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */