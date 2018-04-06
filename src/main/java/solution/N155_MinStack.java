package solution;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class N155_MinStack {
    public class MinStack{
        Stack<Integer> stackDate = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();

        public MinStack() {

        }

        public void push(int x) {
            stackDate.push(x);
            if(stackMin.isEmpty() || stackMin.peek() >= x){
                stackMin.push(x);
            }else{
                stackMin.push(stackMin.peek());
            }
        }

        public void pop() {
            stackDate.pop();
            stackMin.pop();
        }

        public int top() {
            return stackDate.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }

}
