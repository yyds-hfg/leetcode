package leetcode.editor.cn;

/**
 * 题目名字---:删除链表的倒数第 N 个结点
 * 题目编号---:19
 * 解题时间---:2022-06-29 22:23:47
 */

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        solution.removeNthFromEnd(node1,2);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head==null) {
                return null;
            }
            //定义一个哨兵节点
            ListNode sentinel = new ListNode(-1);
            sentinel.next = head;
            //遍历链表获取长度  5-2=3
            Integer listLength = getListLength(sentinel.next);
            ListNode curr = sentinel;
            //找到倒数第n个
            for(int count=0;listLength-n>count; count++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return sentinel.next;
        }

        private Integer getListLength(ListNode sentinel) {
            int length =0;
            for (; sentinel !=null; sentinel = sentinel.next) {
                length++;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}