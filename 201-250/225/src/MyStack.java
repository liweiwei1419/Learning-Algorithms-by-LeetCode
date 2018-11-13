import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 * 参考资料：https://blog.csdn.net/derrantcm/article/details/48084069
 * 用队列实现栈
 *
 * @author liwei
 */
public class MyStack {

    private LinkedList<Integer> list1;
    private LinkedList<Integer> list2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 这里很关键
        if (!list1.isEmpty()) {
            list1.addLast(x);
        } else {
            list2.addLast(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // 直接交换指针！
        // 直接交换指针！
        // 直接交换指针！
        if (list1.isEmpty()) {
            LinkedList<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }
        while (list1.size() > 1) {
            list2.addLast(list1.removeFirst());
        }
        return list1.removeFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (list1.isEmpty()) {
            LinkedList<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }
        while (list1.size() > 1) {
            list2.addLast(list1.removeFirst());
        }
        list2.addLast(list1.get(0));
        return list1.removeFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list1.isEmpty() && list2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */