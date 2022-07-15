package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目名字---:有效的括号
 * 题目编号---:20
 * 解题时间---:2022-07-15 22:18:45
 */

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                        stack.push(')');
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case '{':
                        stack.push('}');
                        break;
                    default:
                        if (stack.isEmpty())
                            return false;
                        char right = stack.pop();
                        if (c != right)
                            return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}