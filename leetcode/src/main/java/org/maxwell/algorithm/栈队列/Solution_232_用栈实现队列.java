package org.maxwell.algorithm.栈队列;

import java.util.Stack;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/16 11:39
 */
public class Solution_232_用栈实现队列 {

    /**
     * 用两个栈实现队列
     */
    class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty())
                in20ut();
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty())
                in20ut();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty()&&outStack.isEmpty();
        }

        private void in20ut() {
            while (!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
    }

}
