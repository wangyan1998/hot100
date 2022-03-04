package algorithm;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//链表中节点的数目范围是 [0, 5000]
//        -5000 <= Node.val <= 5000
import tool.ListNode;

import java.util.Stack;

/**
 * @author wy
 * @date 2022/3/1 21:41
 */
public class ReverseList {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
