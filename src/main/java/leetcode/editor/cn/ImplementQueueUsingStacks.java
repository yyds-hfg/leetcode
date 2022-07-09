package leetcode.editor.cn;

import java.util.Stack;

/**
 * 题目名字---:用栈实现队列
 * 题目编号---:232
 * 解题时间---:2022-07-09 23:01:05
 */

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /**
         * 将元素 x 推到队列的末尾
         */
        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        /**
         * 从队列的开头移除并返回元素
         */
        public int pop() {
            return stack1.pop();
        }

        /**
         * 返回队列开头的元素
         */
        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
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
//leetcode submit region end(Prohibit modification and deletion)


}