package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
题目名字---:用队列实现栈
题目编号---:225	
解题时间---:2022-07-09 22:29:44
*/

public class ImplementStackUsingQueues{
    public static void main(String[] args) {
//        Solution solution = new ImplementStackUsingQueues().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> queue1;
    public MyStack() {
        queue1 = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = queue1.size();
        queue1.offer(x);
        for (int i = 0; i < size; i++) {
            queue1.offer(queue1.poll());
        }
    }
    
    public int pop() {
        if (!queue1.isEmpty())
            return queue1.poll();
        return -1;
    }
    
    public int top() {
        if (!queue1.isEmpty())
            return queue1.peek();
        return -1;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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
//leetcode submit region end(Prohibit modification and deletion)


}